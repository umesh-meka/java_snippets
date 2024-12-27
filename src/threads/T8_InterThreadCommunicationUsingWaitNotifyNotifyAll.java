package threads;

class SharedResource {
    private String message;

    // Producer thread waits if message is already set.
    public synchronized void produceMessage(String message) {
        while (this.message != null) {  // If there's already a message, wait.
            try {
                System.out.println("Message  tobe consumed");
                wait();  // Wait until the message is consumed.
                System.out.println("Producer notified");
            } catch (InterruptedException e) {
            	System.out.println("In Producer Error");
                Thread.currentThread().interrupt();
            }
        }
        this.message = message;
        System.out.println("Produced: " + message);
        notify();  // Notify the consumer that the message is ready.
    }

    // Consumer thread waits for the message.
    public synchronized void consumeMessage() {
        while (this.message == null) {  // Wait until a message is produced.
            try {
                System.out.println("Message  tobe produced");
                wait();
                System.out.println("Consumer notified");
            } catch (InterruptedException e) {
            	System.out.println("In Consumer Error");
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Consumed: " + message);
        message = null;
        notify();  // Notify the producer that the message is consumed.
    }
}

public class T8_InterThreadCommunicationUsingWaitNotifyNotifyAll {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // Producer thread
        Thread producer = new Thread(() -> {
            sharedResource.produceMessage("Hello, Consumer!");
        });
        
        // Producer thread
        Thread producer2 = new Thread(() -> {
            sharedResource.produceMessage("Hello, Consumer2!");
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            sharedResource.consumeMessage();
        });

        //producer2.start();
        consumer.start();
        producer.start();
    }
}
