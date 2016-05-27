package org.learning.common.parts;

import org.springframework.restdocs.snippet.IgnorableDescriptor;

/**
 * A descriptor of a request part
 *
 * Created by Lingfeng on 2016/5/12.
 */
public class PartDescriptor extends IgnorableDescriptor<PartDescriptor> {

    private final String name;

    /**
     * Creates a new {@code PartsDescriptor} describing the part with the given
     * {@code name}.
     *
     * @param name the name of the part
     */
    protected PartDescriptor(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the part being described by this descriptor.
     *
     * @return the name of the part
     */
    public final String getName() {
        return this.name;
    }
}
