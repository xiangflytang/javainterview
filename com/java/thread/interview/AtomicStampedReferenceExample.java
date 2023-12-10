package com.java.thread.interview;
import java.util.concurrent.atomic.AtomicReference;


import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceExample {
    public static void main(String[] args) {
        // Initial value is 100, with initial timestamp 0
        AtomicStampedReference<Integer> atomicStampedRef = new AtomicStampedReference<>(100, 0);

        System.out.println("Initial value: " + atomicStampedRef.getReference());

        // Simulate an ABA problem
        int expectedValue = atomicStampedRef.getReference();
        int newStamp = atomicStampedRef.getStamp() + 1;
        int newValue = 200;
        atomicStampedRef.set(newValue, newStamp);

        // Attempt to perform CAS
        boolean success = atomicStampedRef.compareAndSet(expectedValue, newValue, 0, newStamp);
        System.out.println("CAS success: " + success);

        // Check the updated value and stamp
        System.out.println("Updated value: " + atomicStampedRef.getReference());
        System.out.println("Updated stamp: " + atomicStampedRef.getStamp());
    }
}