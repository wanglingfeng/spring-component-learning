package org.learning.common.parts;

import org.springframework.restdocs.operation.Operation;
import org.springframework.restdocs.operation.OperationRequestPart;
import org.springframework.restdocs.snippet.SnippetException;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Lingfeng on 2016/5/12.
 */
public class RequestPartsSnippet extends AbstractPartsSnippet {
    /**
     * Creates a new {@code RequestPartsSnippet} that will document the request's
     * parts using the given {@code descriptors}.
     *
     * @param descriptors the part descriptors
     */
    protected RequestPartsSnippet(List<PartDescriptor> descriptors) {
        this(descriptors, null);
    }

    /**
     * Creates a new {@code RequestParametersSnippet} that will document the request's
     * parameters using the given {@code descriptors}. The given {@code attributes} will
     * be included in the model during template rendering.
     *
     * @param descriptors the parameter descriptors
     * @param attributes the additional attributes
     */
    protected RequestPartsSnippet(List<PartDescriptor> descriptors,
                                  Map<String, Object> attributes) {
        super("request-parts", descriptors, attributes);
    }

    @Override
    protected void verificationFailed(Set<String> undocumentedParts,
                                      Set<String> missingParts) {
        String message = "";
        if (!undocumentedParts.isEmpty()) {
            message += "Request parts with the following names were not documented: "
                    + undocumentedParts;
        }
        if (!missingParts.isEmpty()) {
            if (message.length() > 0) {
                message += ". ";
            }
            message += "Request parts with the following names were not found in the request: "
                    + missingParts;
        }
        throw new SnippetException(message);
    }

    @Override
    protected Set<String> extractActualParts(Operation operation) {
        return operation.getRequest().getParts().stream()
                .map(OperationRequestPart::getName).collect(Collectors.toSet());
    }

}
