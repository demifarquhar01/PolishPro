package demifarquhar01;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;
import org.junit.Test;

import demifarquhar01.creational_pattern.Singleton;

public class SingletonTest {

    @Test
    public void testSingletonReturnsSameInstance() {
        Singleton.ITAdministrator admin1 = Singleton.ITAdministrator.getInstance();
        Singleton.ITAdministrator admin2 = Singleton.ITAdministrator.getInstance();

        assertNotNull(admin1);
        assertNotNull(admin2);
        assertSame("Both instances should be the same (singleton)", admin1, admin2); // ✅ JUnit 4 format
    }

    @Test
    public void testHandleEmailFailureMethod() {
        try {
            Singleton.ITAdministrator admin = Singleton.ITAdministrator.getInstance();
            admin.handleEmailFailure(); // Verify it doesn’t throw
        } catch (Exception e) {
            fail("Method threw an exception: " + e.getMessage());
        }
    }

    @Test
    public void testSingletonThreadSafety() throws InterruptedException {
        final int threadCount = 10;
        final CountDownLatch latch = new CountDownLatch(threadCount);
        final AtomicReference<Singleton.ITAdministrator> ref = new AtomicReference<>();

        Runnable task = () -> {
            Singleton.ITAdministrator instance = Singleton.ITAdministrator.getInstance();
            ref.compareAndSet(null, instance);
            assertSame(ref.get(), instance); // ✅ Same instance in each thread
            latch.countDown();
        };

        for (int i = 0; i < threadCount; i++) {
            new Thread(task).start();
        }

        latch.await(); // Wait for all threads to complete
    }
}

    