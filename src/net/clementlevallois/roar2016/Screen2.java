/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.clementlevallois.roar2016;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.processing.Result;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;



/**
 * GUI builder created Form
 *
 * @author LEVALLOIS
 */
public class Screen2 extends com.codename1.ui.Form {

    public Screen2() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public Screen2(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField();
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Text_Field_1.addActionListener(callback);
        gui_Button_1.addActionListener(callback);
        gui_Button_2.addActionListener(callback);
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

            if(sourceComponent == gui_Text_Field_1) {
                onText_Field_1ActionEvent(ev);
            }
            if(sourceComponent == gui_Button_1) {
                onButton_1ActionEvent(ev);
            }
            if(sourceComponent == gui_Button_2) {
                onButton_2ActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Write a roaaaar!");
        setName("Screen2");
        addComponent(gui_Text_Field_1);
        addComponent(gui_Button_1);
        addComponent(gui_Button_2);
        gui_Text_Field_1.setText("write your roar here!");
        gui_Text_Field_1.setName("Text_Field_1");
        gui_Button_1.setText("send it");
        gui_Button_1.setName("Button_1");
        gui_Button_2.setText("Go to the roar wall");
        gui_Button_2.setName("Button_2");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onText_Field_1ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        
        
    }

    public void onButton_1ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        
    //creating a box storing several elements of text: the author, and the text of the roar itself
      Hashtable msgToBeSent;
      msgToBeSent = new Hashtable();
      msgToBeSent.put("username", Screen1.username);
      msgToBeSent.put("text", gui_Text_Field_1.getText());

    //converting our box into text in json    
      final String msgJson = Result.fromContent(msgToBeSent).toString();
      

    //the address where we send our msg
    String url = "https://roar.firebaseio.com/roar.json";
    
    

    //establishing a connection to internet and sending the msg
     ConnectionRequest request;
     request = new ConnectionRequest(){
            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                os.write(msgJson.getBytes("UTF-8"));
            }
        };

    //setting some parameters for the connection
    request.setUrl(url);
    request.setPost(true);
    request.setHttpMethod("POST");
    request.setContentType("application/json");
    

    //launching the connection
    NetworkManager.getInstance().addToQueueAndWait(request);
    
    
    
    
    
    }

    public void onButton_2ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        Screen3 box;
        box = new Screen3();
        box.show();               
        
    }

}
