
package com.company.security;

public class AccessModifierDemo {
    private int privateField;
    String defaultField;             
    protected double protectedField;
    public boolean publicField;
    public AccessModifierDemo(int privateField, String defaultField, double protectedField, boolean publicField) {
        this.privateField = privateField;
        this.defaultField = defaultField;
        this.protectedField = protectedField;
        this.publicField = publicField;
    }
    private void privateMethod() {
        System.out.println("Private method called");
    }

    void defaultMethod() {
        System.out.println("Default method called");
    }

    protected void protectedMethod() {
        System.out.println("Protected method called");
    }

    public void publicMethod() {
        System.out.println("Public method called");
    }

    public void testInternalAccess() {
        System.out.println("Inside testInternalAccess()");
        System.out.println("privateField = " + privateField);
        System.out.println("defaultField = " + defaultField);
        System.out.println("protectedField = " + protectedField);
        System.out.println("publicField = " + publicField);

        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
    }

    public static void main(String[] args) {
        AccessModifierDemo obj = new AccessModifierDemo(10, "Hello", 99.9, true);

        System.out.println(obj.defaultField);      // ✅ works (same package)
        System.out.println(obj.protectedField);    // ✅ works (same package)
        System.out.println(obj.publicField);       // ✅ works everywhere

        obj.defaultMethod();      // ✅ works (same package)
        obj.protectedMethod();    // ✅ works (same package)
        obj.publicMethod();       // ✅ works everywhere

        // Internal test
        obj.testInternalAccess();
    }
}

// Second class in the SAME package
class SamePackageTest {
    public static void testAccess() {
        AccessModifierDemo obj = new AccessModifierDemo(20, "World", 55.5, false);

        // System.out.println(obj.privateField);   // ❌ ERROR: private
        System.out.println(obj.defaultField);      // ✅ works (same package)
        System.out.println(obj.protectedField);    // ✅ works (same package)
        System.out.println(obj.publicField);       // ✅ works everywhere

        // obj.privateMethod();   // ❌ ERROR: private
        obj.defaultMethod();      // ✅ works (same package)
        obj.protectedMethod();    // ✅ works (same package)
        obj.publicMethod();       // ✅ works everywhere
    }
}
