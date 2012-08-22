package de.fforw.svenson.example.model;

/**
 * Message of type A.
 */
public class DomainA
    extends Base
{
    private int foo = 1;

    public int getFoo()
    {
        return foo;
    }

    public void setFoo(int foo)
    {
        this.foo = foo;
    }
    
    @Override
    public String toString()
    {
        return super.toString() + ": foo = " + foo;
    }
    
}
