/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.clementlevallois.roar2016;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.io.Util;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.Layout;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * GUI builder created Form
 *
 * @author LEVALLOIS
 */
public class Screen3 extends com.codename1.ui.Form {

    public Screen3() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public Screen3(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button_2.addActionListener(callback);
        gui_Button_1.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();
            if(sourceComponent.getParent().getLeadParent() != null) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == gui_Button_2) {
                onButton_2ActionEvent(ev);
            }
            if(sourceComponent == gui_Button_1) {
                onButton_1ActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Roaaaar wall");
        setName("Screen3");
        addComponent(gui_Button_2);
        addComponent(gui_Button_1);
        gui_Button_2.setText("Write a roar");
        gui_Button_2.setName("Button_2");
        gui_Button_1.setText("refresh!");
        gui_Button_1.setName("Button_1");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onButton_1ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        try {
            String roars = "https://roar.firebaseIO.com/roar.json";

            //if we want to retrieve only the latest 10 roars posted
            //String roars = "https://roar.firebaseIO.com/roar.json" + "?" + "orderBy=\"$key\"" + "&" + "limitToLast=10";
            ConnectionRequest request = new ConnectionRequest();
            request.setUrl(roars);
            request.setPost(false);
            request.setHttpMethod("GET");
            request.setContentType("application/json");

            NetworkManager.getInstance().addToQueueAndWait(request);

            ByteArrayInputStream allRoarsInBytes = new ByteArrayInputStream(request.getResponseData());
            String responseInString = Util.readToString(allRoarsInBytes, "UTF-8");

            JSONObject allRoarsInJsonFormat = new JSONObject(responseInString);
            JSONArray listOfRoarIds = allRoarsInJsonFormat.names();

            Form wallScreen = this.getComponentForm();

            Container myContainerForAllRoars = new Container();
            Layout myLayout = new BoxLayout(BoxLayout.Y_AXIS);
            myContainerForAllRoars.setLayout(myLayout);

            Integer counterOfRoars = 0;

            while (counterOfRoars < allRoarsInJsonFormat.length()) {
                String idOfOneRoar = listOfRoarIds.getString(counterOfRoars);
                JSONObject oneRoarInJsonFormat = (JSONObject) allRoarsInJsonFormat.get(idOfOneRoar);
                System.out.println("oneRoarInJsonFormat: " + oneRoarInJsonFormat.toString());

                Container myRoarContainer = new Container();

                String username = oneRoarInJsonFormat.getString("username");
                String text = oneRoarInJsonFormat.getString("text");

                Label myLabelForAuthor = new Label(username);
                Label myLabelForRoar = new Label(text);

                myRoarContainer.addComponent(myLabelForAuthor);
                myRoarContainer.addComponent(myLabelForRoar);

                myContainerForAllRoars.addComponent(myRoarContainer);

                counterOfRoars = counterOfRoars + 1;

            }
            wallScreen.addComponent(wallScreen.getComponentCount(), myContainerForAllRoars);
            wallScreen.revalidate();
        } catch (IOException ex) {
            System.out.println("Error:" + ex);
        } catch (JSONException ex) {
            System.out.println("Error:" + ex);

        }

    }

    public void onButton_2ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        Screen2 box;
        box = new Screen2();
        box.show();
    }

}
