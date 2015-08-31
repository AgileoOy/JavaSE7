package fi.agileo.fxdemos;
/**
 * Example: using JavaFX collections.
 *
 * @author Juha Peltomäki
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableMap;
import javafx.collections.MapChangeListener;

public class JavaFxCollectionExample {

    public static void runObservableList() {
        // Creating ArrayList object which is given as a parameter to FXCollections.fxList()
        List<String> list = new ArrayList<String>();
        list.add("First item");
        ObservableList<String> fxList = FXCollections.observableList(list);

        fxList.addListener(new ListChangeListener<String>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends String> change) {
                while (change.next()) {
                    if (change.wasAdded()) {
                        List added = change.getAddedSubList();
                        System.out.print("New item in observableList: ");
                        System.out.println(added);
                    }
                }

            }
        });

        fxList.add("adding new FX list item");
        list.add("adding new ArrayList item");
        fxList.add("adding another FX list item");

        System.out.println("ArrayList Size: " + fxList.size());
        System.out.println("ObservableList Size: " + list.size());
    }

    public static void runObservableMap() {
        // Creating HashMap object which is given as a parameter to fxMap()
        Map<String, String> map = new HashMap<String, String>();
        map.put("first", "adding first HashMap item");
        ObservableMap<String, String> fxMap = FXCollections.observableMap(map);

        fxMap.addListener(new MapChangeListener<String, String>() {
            @Override
            public void onChanged(MapChangeListener.Change<? extends String, ? extends String> change) {
                if (change.wasAdded()) {
                    String added = change.getValueAdded();
                    System.out.print("New item in observableMap: ");
                    System.out.println(added);
                }
                System.out.println("Current map:" + change.getMap());
            }
        });

        map.put("third", "adding new HashMap item");
        fxMap.put("second", "add new FX map item");
    }

    public static void main(String[] args) {
        runObservableList();
        runObservableMap();
    }
}
