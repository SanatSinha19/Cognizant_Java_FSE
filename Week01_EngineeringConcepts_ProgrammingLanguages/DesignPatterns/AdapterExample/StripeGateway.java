public class StripeGateway {
    public void sendPayment(double amountInCents) {
        System.out.println("Processing " + amountInCents + " cents payment via Stripe.");
    }
}