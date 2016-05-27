package org.learning.common.parts;

import org.springframework.restdocs.operation.OperationRequest;
import org.springframework.restdocs.snippet.Snippet;

import java.util.Arrays;

/**
 * Static factory methods for documenting aspects of a request sent to a RESTful API.
 *
 * Created by Lingfeng on 2016/5/12.
 */
public abstract class RequestPartsDocumentation {

    /**
     * Creates a {@link PartDescriptor} that describes a request part
     * with the given {@code name}.
     *
     * @param name The name of the part
     * @return a {@link PartDescriptor} ready for further configuration
     */
    public static PartDescriptor partWithName(String name) {
        return new PartDescriptor(name);
    }

    /**
     * Returns a {@code Snippet} that will document the parts from the API
     * operation's request. The parts will be documented using the given
     * {@code descriptors}.
     * <p>
     * If a part is present in the request, but is not documented by one of the
     * descriptors, a failure will occur when the snippet is invoked. Similarly, if a
     * part is documented, is not marked as optional, and is not present in the
     * request, a failure will also occur.
     * <p>
     * If you do not want to document a request part, a part descriptor can be
     * marked as {@link PartDescriptor#ignored}. This will prevent it from appearing
     * in the generated snippet while avoiding the failure described above.
     *
     * @param descriptors The descriptions of the request's parts
     * @return the snippet
     * @see OperationRequest#getParts()
     */
    public static Snippet requestParts(PartDescriptor... descriptors) {
        return new RequestPartsSnippet(Arrays.asList(descriptors));
    }
}
