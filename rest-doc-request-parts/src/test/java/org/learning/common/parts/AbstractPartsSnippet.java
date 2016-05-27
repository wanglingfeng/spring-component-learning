package org.learning.common.parts;

import org.springframework.restdocs.operation.Operation;
import org.springframework.restdocs.snippet.TemplatedSnippet;
import org.springframework.util.Assert;

import java.util.*;

/**
 * Created by Lingfeng on 2016/5/12.
 */
public abstract class AbstractPartsSnippet extends TemplatedSnippet {

    private final Map<String, PartDescriptor> descriptorsByName = new LinkedHashMap<>();

    /**
     * Creates a new {@code AbstractPartsSnippet} that will produce a snippet with
     * the given {@code snippetName} that will document parts using the given
     * {@code descriptors}. The given {@code attributes} will be included in the model
     * during template rendering.
     *
     * @param snippetName The snippet name
     * @param descriptors The descriptors
     * @param attributes The additional attributes
     */
    protected AbstractPartsSnippet(String snippetName,
                                   List<PartDescriptor> descriptors, Map<String, Object> attributes) {
        super(snippetName, attributes);
        for (PartDescriptor descriptor : descriptors) {
            Assert.notNull(descriptor.getName(), "Parts descriptors must have a name");
            if (!descriptor.isIgnored()) {
                Assert.notNull(descriptor.getDescription(),
                        "The descriptor for part '" + descriptor.getName()
                                + "' must either have a description or be marked as "
                                + "ignored");
            }
            this.descriptorsByName.put(descriptor.getName(), descriptor);
        }
    }

    @Override
    protected Map<String, Object> createModel(Operation operation) {
        verifyPartDescriptors(operation);

        Map<String, Object> model = new HashMap<>();
        List<Map<String, Object>> parts = new ArrayList<>();
        for (Map.Entry<String, PartDescriptor> entry : this.descriptorsByName.entrySet()) {
            PartDescriptor descriptor = entry.getValue();
            if (!descriptor.isIgnored()) {
                parts.add(createModelForDescriptor(descriptor));
            }
        }
        model.put("parts", parts);
        return model;
    }

    private void verifyPartDescriptors(Operation operation) {
        Set<String> actualParts = extractActualParts(operation);
        Set<String> expectedParts = this.descriptorsByName.keySet();
        Set<String> undocumentedParts = new HashSet<>(actualParts);
        undocumentedParts.removeAll(expectedParts);
        Set<String> missingParts = new HashSet<>(expectedParts);
        missingParts.removeAll(actualParts);

        if (!undocumentedParts.isEmpty() || !missingParts.isEmpty()) {
            verificationFailed(undocumentedParts, missingParts);
        }
    }

    /**
     * Extracts the names of the parameters that were present in the given
     * {@code operation}.
     *
     * @param operation the operation
     * @return the parameters
     */
    protected abstract Set<String> extractActualParts(Operation operation);

    /**
     * Called when the documented parameters do not match the actual parameters.
     *
     * @param undocumentedParameters the parameters that were found in the operation but
     * were not documented
     * @param missingParameters the parameters that were documented but were not found in
     * the operation
     */
    protected abstract void verificationFailed(Set<String> undocumentedParameters,
                                               Set<String> missingParameters);

    /**
     * Returns a {@code Map} of {@link PartDescriptor PartDescriptors} that will
     * be used to generate the documentation key by their
     * {@link PartDescriptor#getName()}.
     *
     * @return the map of path descriptors
     */
    protected final Map<String, PartDescriptor> getFieldDescriptors() {
        return this.descriptorsByName;
    }

    /**
     * Returns a model for the given {@code descriptor}.
     *
     * @param descriptor the descriptor
     * @return the model
     */
    protected Map<String, Object> createModelForDescriptor(PartDescriptor descriptor) {
        Map<String, Object> model = new HashMap<>();
        model.put("name", descriptor.getName());
        model.put("description", descriptor.getDescription());
        model.putAll(descriptor.getAttributes());
        return model;
    }
}
