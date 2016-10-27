/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.clementlevallois.roar2016;

/**
 * GUI builder created Form
 *
 * @author LEVALLOIS
 */
public class Screen1 extends com.codename1.ui.Form {

    static String username;
    
    
    public Screen1() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public Screen1(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField();
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Text_Field_1.addActionListener(callback);
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

            if(sourceComponent == gui_Text_Field_1) {
                onText_Field_1ActionEvent(ev);
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
        setTitle("Please login");
        setName("Screen1");
        addComponent(gui_Text_Field_1);
        addComponent(gui_Button_1);
        gui_Text_Field_1.setText("write your name here");
        gui_Text_Field_1.setName("Text_Field_1");
        gui_Button_1.setText("next");
        gui_Button_1.setName("Button_1");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onText_Field_1ActionEvent(com.codename1.ui.events.ActionEvent ev) {
       username = gui_Text_Field_1.getText();
    
    }

    public void onButton_1ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        Screen2 box;
        box = new Screen2();
        box.show();        
    }

}
