package de.fforw.svenson.examples.model;

import org.svenson.JSONProperty;

/**
 * Base class for all JSON messages.
 *
 */
public abstract class Base
{
    /**
     * Read-only field providing the discrimator field value from the simple class name of the current instance.
     * @return
     */
    @JSONProperty(readOnly = true)
    public String getType()
    {
        return this.getClass().getSimpleName();
    }
}
