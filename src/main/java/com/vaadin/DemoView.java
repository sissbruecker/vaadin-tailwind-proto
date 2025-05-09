package com.vaadin;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Route;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Route("")
public class DemoView extends Div {

    public DemoView() {
        Div grid = new Div();
        grid.setSizeFull();

        for (int i = 0; i < PEOPLE.size(); i++) {
            var card = createPersonCard(PEOPLE.get(i));
            card.setId("card-" + i);
            grid.add(card);
        }

        grid.setClassName("p-4 box-border grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4");

        add(grid);
    }

    private Div createPersonCard(Person person) {
        var card = new Div();
        card.setClassName("bg-white rounded-lg shadow-md overflow-hidden hover:shadow-lg transition-shadow duration-300 flex flex-col h-full");

        var header = new Div();
        header.setClassName("p-4 bg-gray-200 text-white");

        var name = new H3(person.firstName() + " " + person.lastName());
        name.setClassName("text-xl font-bold");

        var statusBadge = new Span(person.status());
        String statusClass = "ml-2 px-2 py-1 text-xs rounded-full ";
        if ("Busy".equals(person.status())) {
            statusClass += "bg-red-200 text-red-800";
        } else {
            statusClass += "bg-green-200 text-green-800";
        }
        statusBadge.setClassName(statusClass);

        var nameRow = new Div();
        nameRow.setClassName("flex items-center justify-between");
        nameRow.add(name, statusBadge);
        header.add(nameRow);

        var content = new Div();
        content.setClassName("p-4 flex-grow");

        var profession = new H4(person.profession());
        profession.setClassName("text-lg font-semibold text-gray-700 mb-2");
        content.add(profession);

        var emailContainer = new Div();
        emailContainer.setClassName("mb-2");
        var emailLabel = new Span("Email: ");
        emailLabel.setClassName("text-gray-600 font-medium");
        var emailValue = new Span(person.email());
        emailValue.setClassName("text-gray-800");
        emailContainer.add(emailLabel, emailValue);
        content.add(emailContainer);

        var birthdayContainer = new Div();
        birthdayContainer.setClassName("mb-2");
        var birthdayLabel = new Span("Birthday: ");
        birthdayLabel.setClassName("text-gray-600 font-medium");
        var birthdayValue = new Span(person.birthday().format(DateTimeFormatter.ofPattern("MMMM d, yyyy")));
        birthdayValue.setClassName("text-gray-800");
        birthdayContainer.add(birthdayLabel, birthdayValue);
        content.add(birthdayContainer);

        var footer = new Div();
        footer.setClassName("mt-auto border-t border-gray-200");

        var membershipBadge = new Div();
        String membershipClass = "px-3 py-2 text-sm font-medium ";
        switch (person.membership()) {
            case "Premium":
                membershipClass += "bg-purple-100 text-purple-800";
                break;
            case "VIP":
                membershipClass += "bg-yellow-100 text-yellow-800";
                break;
            default:
                membershipClass += "bg-blue-100 text-blue-800";
                break;
        }
        membershipBadge.setClassName(membershipClass);
        membershipBadge.add("Membership: " + person.membership());
        footer.add(membershipBadge);

        card.add(header, content, footer);

        return card;
    }

    public record Person(
            String firstName,
            String lastName,
            String email,
            String id,
            boolean subscriber,
            String membership,
            String pictureUrl,
            String profession,
            LocalDate birthday,
            String managerId,
            String status,
            boolean manager
    ) {}

    private static final List<Person> PEOPLE = List.of(
            new Person("Aria", "Bailey", "aria.bailey@company.com", "0", true, "Premium", "", "Endocrinologist", LocalDate.parse("1984-01-13"), null, "Busy", true),
            new Person("Aaliyah", "Butler", "aaliyah.butler@company.com", "1", true, "VIP", "", "Nephrologist", LocalDate.parse("1977-07-12"), null, "Available", true),
            new Person("Eleanor", "Price", "eleanor.price@company.com", "2", true, "Regular", "", "Ophthalmologist", LocalDate.parse("1976-12-14"), null, "Available", true),
            new Person("Allison", "Torres", "allison.torres@company.com", "3", false, "Regular", "", "Allergist", LocalDate.parse("1972-12-04"), null, "Available", true),
            new Person("Madeline", "Lewis", "madeline.lewis@company.com", "4", false, "VIP", "", "Gastroenterologist", LocalDate.parse("1978-02-03"), null, "Busy", true),
            new Person("Anna", "Myers", "anna.myers@company.com", "5", true, "Premium", "", "Anesthesiologist", LocalDate.parse("1990-04-23"), null, "Available", true),
            new Person("Ashley", "Howard", "ashley.howard@company.com", "6", true, "Regular", "", "Urologist", LocalDate.parse("1977-06-27"), null, "Available", true),
            new Person("Cooper", "Phillips", "cooper.phillips@company.com", "7", false, "Premium", "", "Cardiologist", LocalDate.parse("1975-01-01"), null, "Busy", true),
            new Person("Lauren", "Wright", "lauren.wright@company.com", "8", false, "Regular", "", "Pediatrician", LocalDate.parse("1974-09-13"), null, "Available", true),
            new Person("Abigail", "Lewis", "abigail.lewis@company.com", "9", false, "Regular", "", "Nephrologist", LocalDate.parse("1979-03-07"), "1", "Available", false),
            new Person("Ryder", "Turner", "ryder.turner@company.com", "10", false, "Premium", "", "Pulmonologist", LocalDate.parse("1986-09-03"), null, "Available", true),
            new Person("Isaac", "Jones", "isaac.jones@company.com", "11", true, "VIP", "", "Podiatrist", LocalDate.parse("1974-02-27"), null, "Busy", true),
            new Person("Amelia", "Evans", "amelia.evans@company.com", "12", true, "Premium", "", "Surgeon", LocalDate.parse("1985-12-20"), null, "Available", true),
            new Person("Grace", "Wilson", "grace.wilson@company.com", "13", false, "Regular", "", "Cardiologist", LocalDate.parse("1973-03-21"), "7", "Available", false),
            new Person("Zoe", "Robinson", "zoe.robinson@company.com", "14", true, "Premium", "", "Obstetrician", LocalDate.parse("1975-06-22"), null, "Available", true),
            new Person("Connor", "Garcia", "connor.garcia@company.com", "15", true, "Regular", "", "Neurologist", LocalDate.parse("1977-03-12"), null, "Available", true),
            new Person("Jeremiah", "Foster", "jeremiah.foster@company.com", "16", true, "Regular", "", "Endocrinologist", LocalDate.parse("1976-01-01"), "0", "Available", false),
            new Person("Amelia", "Hall", "amelia.hall@company.com", "17", true, "Premium", "", "Ophthalmologist", LocalDate.parse("1976-06-20"), "2", "Available", false),
            new Person("Leo", "Turner", "leo.turner@company.com", "18", false, "VIP", "", "Surgeon", LocalDate.parse("1975-03-09"), "12", "Available", false),
            new Person("David", "Long", "david.long@company.com", "19", false, "Premium", "", "Oncologist", LocalDate.parse("1980-11-14"), null, "Available", true)
    );
}
