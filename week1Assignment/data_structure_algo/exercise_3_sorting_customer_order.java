class Order {

    int orderId;
    String customerName;
    double totalPrice;

    // Constructor
    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    // Display Order Details
    public void display() {
        System.out.println("Order ID      : " + orderId);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Total Price   : ₹" + totalPrice);
        System.out.println("---------------------------");
    }
}

public class exercise_3_sorting_customer_order {

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {

        int n = orders.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (orders[j].totalPrice > orders[j + 1].totalPrice) {

                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(Order[] orders, int low, int high) {

        if (low < high) {

            int pivotIndex = partition(orders, low, high);

            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    // Partition Function
    public static int partition(Order[] orders, int low, int high) {

        double pivot = orders[high].totalPrice;

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (orders[j].totalPrice < pivot) {

                i++;

                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    // Display Orders
    public static void displayOrders(Order[] orders) {

        for (Order order : orders) {
            order.display();
        }
    }

    public static void main(String[] args) {

        Order[] orders = {

                new Order(101, "Prateek", 2500),
                new Order(102, "Rahul", 1500),
                new Order(103, "Aman", 5000),
                new Order(104, "Sneha", 3200),
                new Order(105, "Riya", 2100)

        };

        // Bubble Sort
        System.out.println("Orders Sorted Using Bubble Sort\n");

        bubbleSort(orders);

        displayOrders(orders);

        // Create another array for Quick Sort
        Order[] orders2 = {

                new Order(101, "Prateek", 2500),
                new Order(102, "Rahul", 1500),
                new Order(103, "Aman", 5000),
                new Order(104, "Sneha", 3200),
                new Order(105, "Riya", 2100)

        };

        // Quick Sort
        quickSort(orders2, 0, orders2.length - 1);

        System.out.println("\nOrders Sorted Using Quick Sort\n");

        displayOrders(orders2);
    }
}