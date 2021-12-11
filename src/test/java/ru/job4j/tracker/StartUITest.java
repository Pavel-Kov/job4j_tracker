package ru.job4j.tracker;

import org.junit.Test;
import java.time.format.DateTimeFormatter;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        UserAction[] actions = new UserAction[]{
                new EditItemAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu." + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindAllItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new ShowItemAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        String name = one.getName();
        String id = String.valueOf(one.getId());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String created = one.getCreated().format(format);
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + "Item{id=" + id + ", name='" + name + "', created=" + created + "}" + ln
                        + "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindByNameItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String name = "test1";
        Input in = new StubInput(
                new String[] {"0", name, "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindNameItemAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        String id = String.valueOf(one.getId());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String created = one.getCreated().format(format);
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + "Item{id=" + id + ", name='" + name + "', created=" + created + "}" + ln
                        + "Menu." + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindByIdItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String id = String.valueOf(one.getId());
        Input in = new StubInput(
                new String[] {"0", id, "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindIdItemAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        String name = one.getName();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String created = one.getCreated().format(format);
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + "Item{id=" + id + ", name='" + name + "', created=" + created + "}" + ln
                        + "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
        ));
    }
}