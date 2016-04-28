package etape7;

import org.junit.Test;

import etape3.A;
import etape3.B;
import etape3.B2;
import etape3.BTestNOK;
import etape3.BTestOK;
import etape3.I;
import junit.framework.Assert;

public class TestEtape5 {

	@Test
	public void testA() {
		I i = new BTestOK();
		A a = new A(i);
		Assert.assertTrue(a.m());
		I j = new BTestNOK();
		A a2 = new A(j);
		Assert.assertFalse(a2.m());
	}

	@Test
	public void testB() {

		B b = new B();
		Assert.assertTrue(b.q());
	}

	@Test
	public void testB2() {
		B b = new B2();
		Assert.assertTrue(b.q());

	}

}
