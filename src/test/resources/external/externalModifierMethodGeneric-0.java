/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.modifier.Modifiable;
import javax.persistence.Transient;
import javax.annotation.processing.Generated;

@Generated(value = "TestPrototype", comments = "Test")
public class TestImpl implements Test, Modifiable<Test.Modify> {

    protected boolean available;

    protected String external;

    @Transient
    protected Object tag;

    public TestImpl() {
    }

    public String getExternal() {
        return external;
    }

    public String getPreview() {
        return "preview";
    }

    public Object getTag() {
        return tag;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    public Test.Modify with() {
        return new TestModifyImpl();
    }

    protected class TestModifyImpl implements Test.Modify {

        public Test.Modify available(boolean available) {
            TestImpl.this.available = available;
            return this;
        }

        public Test done() {
            return TestImpl.this;
        }

        public Test.Modify external(String external) {
            TestImpl.this.external = external;
            return this;
        }

        public Test.Modify tag(Object tag) {
            TestImpl.this.tag = tag;
            return this;
        }
    }
}
