package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    private List<Event> lesEvents;
    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    public Agenda() {
        lesEvents = new ArrayList<>();
    }
    public void addEvent(Event e) {
        // TODO : implémenter cette méthode
        lesEvents.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return a list of events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        // TODO : implémenter cette méthode
        ArrayList<Event> eventsDay = new ArrayList<>();
        for (Event e : lesEvents) {
            if (e.isInDay(day)) {
                eventsDay.add(e);
            }
        }
        return eventsDay;
    }
    /**
     * Trouver les événements de l'agenda en fonction de leur titre
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public List<Event> findByTitle(String title) {
        // TODO : implémenter cette méthode
        ArrayList<Event> eventsDay = new ArrayList<>();
        for (Event e : lesEvents) {
            if (e.getTitle().equals(title)) {
                eventsDay.add(e);
            }
        }
        return eventsDay;
    }

    /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public boolean isFreeFor(Event e) {
        // TODO : implémenter cette méthode
        for (Event event : lesEvents) {
            if (e.getStart().plus(e.getDuration()).isAfter(event.getStart()) && e.getStart().isBefore(event.getStart().plus(event.getDuration()))) {
                return false;
            }
        }
        return true;
    }
}
