class MessageQueue {
    private String message;
    private boolean hasMessage = false;

    public synchronized void putMessage(String message) {
        while (hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.message = message;
        hasMessage = true;
        System.out.println("Produced: " + message);
        notifyAll();
    }

    public synchronized String getMessage() {
        while (!hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasMessage = false;
        System.out.println("Consumed: " + message);
        notifyAll();
        return message;
    }
}

class Producer extends Thread {
    private MessageQueue queue;

    public Producer(MessageQueue queue) {
        this.queue = queue;
    }


    public void run() {
        String[] messages = {"Hello", "World", "Java", "Multithreading", "End"};
        for (String message : messages) {
            queue.putMessage(message);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer extends Thread {
    private MessageQueue queue;

    public Consumer(MessageQueue queue) {
        this.queue = queue;
    }

       public void run() {
        String message;
        do {
            message = queue.getMessage();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } while (!message.equals("End"));
    }
}

public class IPCWithThreads {
    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        producer.start();
        consumer.start();
    }
}
