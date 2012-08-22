package de.fforw.svenson.examples.model;

/**
 * Message of type B.
 *
 */
public class DomainB
    extends Base
{
    private String bar;

    public String getBar()
    {
        return bar;
    }

    public void setBar(String bar)
    {
        this.bar = bar;
    }

    @Override
    public String toString()
    {
        return super.toString() + ": bar = " + bar;
    }
    
    
}
