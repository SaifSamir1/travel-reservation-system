package prgram_files;

///This class represents details related to a reservation,
// including customer details and reservation date. Additionally,
// it has a nested static class CustomerDetails to encapsulate information
// about the customer
public class ReservationDetails {
    public static ReservationDetails.CustomerDetails customerDetails;
    private String reservationDate;

    public static class CustomerDetails {
        private String customerName;
        private String CustomerId;
        private String contactDetails;

        CustomerDetails(){}
        public CustomerDetails(String customerName, String customerId, String contactDetails) {
            this.customerName = customerName;
            CustomerId = customerId;
            this.contactDetails = contactDetails;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getCustomerId() {
            return CustomerId;
        }

        public void setCustomerId(String customerId) {
            CustomerId = customerId;
        }

        public String getContactDetails() {
            return contactDetails;
        }

        public void setContactDetails(String contactDetails) {
            this.contactDetails = contactDetails;
        }

    }

    public ReservationDetails(String customerName, String customerId, String contactDetails, String reservationDate)
    {
         customerDetails = new CustomerDetails(customerName, customerId, contactDetails);
        this.reservationDate = reservationDate;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }
    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        ReservationDetails.customerDetails = customerDetails;
    }

    public void addDataToCustomerDetailsTableInDatabase() {
        //for adding customer details to the database using the DataBase class
        if ( DataBase.executeQuery("insert into customerdetails (customerId, customerName, customerContact, reservationDate) values (\""+getCustomerDetails().getCustomerId()+"\",\""+getCustomerDetails().getCustomerName()+"\",\""+getCustomerDetails().getContactDetails()+"\",\""+getReservationDate()+"\");")){
            System.out.print("successfully added");
        }
        else{
            System.out.print("Something went wrong");
        }
    }
    }
