package demifarquhar01;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

import demifarquhar01.creational_pattern.Singleton;

public class SingletonTest {
//JUnit 5
    @Test
    public void testSingletonReturnsSameInstance() {
        Singleton.ITAdministrator admin1 = Singleton.ITAdministrator.getInstance();
        Singleton.ITAdministrator admin2 = Singleton.ITAdministrator.getInstance();

        assertNotNull(admin1);
        assertNotNull(admin2);
        assertSame(admin1, admin2, "Both instances should be the same (singleton)");
    }

    @Test
    public void testHandleEmailFailureMethod() {
        Singleton.ITAdministrator admin = Singleton.ITAdministrator.getInstance();
        assertDoesNotThrow(admin::handleEmailFailure, "Method should not throw an exception");
    }

    @Test
    public void testSingletonThreadSafety() throws InterruptedException {
        final int threadCount = 10;
        final CountDownLatch latch = new CountDownLatch(threadCount);
        final AtomicReference<Singleton.ITAdministrator> ref = new AtomicReference<>();

        Runnable task = () -> {
            Singleton.ITAdministrator instance = Singleton.ITAdministrator.getInstance();
            ref.compareAndSet(null, instance);
            assertSame(ref.get(), instance);
            latch.countDown();
        };

        for (int i = 0; i < threadCount; i++) {
            new Thread(task).start();
        }

        latch.await(); // Wait for all threads to complete
    }
}

    