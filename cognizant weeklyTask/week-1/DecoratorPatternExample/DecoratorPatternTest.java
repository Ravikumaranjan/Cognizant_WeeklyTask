public class DecoratorPatternTest {

    public static void main(String[] args) {

        Notifier notifier = new EmailNotifier();

        System.out.println("Email Only:");
        notifier.send("Meeting at 10 AM");

        System.out.println();

        Notifier emailSMS = new SMSNotifierDecorator(new EmailNotifier());
        System.out.println("Email + SMS:");
        emailSMS.send("Project Submitted");

        System.out.println();

        Notifier allChannels =
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()));

        System.out.println("Email + SMS + Slack:");
        allChannels.send("Server is Live");
    }
}
