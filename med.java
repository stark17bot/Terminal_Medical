import java.util.*;

class Patient {
    private int id;
    private String name;
    private int age;
    private String gender;
    private List<String> medicalRecords;

    public Patient(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.medicalRecords = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public List<String> getMedicalRecords() {
        return medicalRecords;
    }

    public void addMedicalRecord(String record) {
        medicalRecords.add(record);
    }

    public void removeMedicalRecord(String record) {
        medicalRecords.remove(record);
    }
}

public class MedicalManagementSystem {
    private List<Patient> patients;

    public MedicalManagementSystem() {
        patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    public Patient findPatient(int patientId) {
        for (Patient patient : patients) {
            if (patient.getId() == patientId) {
                return patient;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MedicalManagementSystem medicalSystem = new MedicalManagementSystem();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Welcome to the Medical Management System!");

            while (true) {
                System.out.println("Enter patient details (ID, Name, Age, Gender) or type 'exit' to quit:");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                String[] details = input.split(",");
                if (details.length != 4) {
                    System.out.println("Invalid input format. Please provide ID, Name, Age, Gender separated by commas.");
                    continue;
                }

                int id = Integer.parseInt(details[0].trim());
                String name = details[1].trim();
                int age = Integer.parseInt(details[2].trim());
                String gender = details[3].trim();

                Patient patient = new Patient(id, name, age, gender);
                medicalSystem.addPatient(patient);
            }

            // Retrieving patient information
            System.out.print("Enter the patient ID: ");
            int patientId = scanner.nextInt();
            Patient currentPatient = medicalSystem.findPatient(patientId);

            if (currentPatient != null) {
                System.out.println("Patient Information:");
                System.out.println("ID: " + currentPatient.getId());
                System.out.println("Name: " + currentPatient.getName());
                System.out.println("Age: " + currentPatient.getAge());
                System.out.println("Gender: " + currentPatient.getGender());

                System.out.println("Medical Records:");
                for (String record : currentPatient.getMedicalRecords()) {
                    System.out.println(record);
                }
            } else {
                System.out.println("Patient ID not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer for patient ID.");
        } finally {
            System.out.println("Thank you for using the Medical Management System!");
            scanner.close();
        }
    }
}