package com.test.selenium.drivers.rule;

import com.test.selenium.drivers.DriverFactory;
import org.junit.internal.AssumptionViolatedException;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 *
 */
public class TestWatcherRule extends TestWatcher {

    public TestWatcherRule() {
        super();
    }

    @Override
    protected void succeeded(Description description) {
        super.succeeded(description);
    }

    @Override
    protected void failed(Throwable e, Description description) {
        super.failed(e, description);
    }

    @Override
    protected void skipped(AssumptionViolatedException e, Description description) {
        super.skipped(e, description);
    }

    @Override
    protected void starting(Description description) {
        super.starting(description);
    }

    @Override
    protected void finished(Description description) {
        super.finished(description);
        DriverFactory.getCurrentDriver().quit();
    }
}
