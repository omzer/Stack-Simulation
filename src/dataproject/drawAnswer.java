package dataproject;

import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class drawAnswer implements Runnable {

    String b = "";
    Istack<String> st = new Istack<>();
    maniFrame x = new maniFrame();

    @Override
    public void run() {

        b = x.txt.getText();
        x.stack2.add(x.sc);
        x.shm.setLocation(5, 0);
        x.shm.setVisible(true);
        StringTokenizer sk = new StringTokenizer(x.txt.getText(), " ", false);
        int val1, val2;
        x.stack1.setText("");
        x.stack2.setText("");
        while (sk.hasMoreTokens()) {
            String a = sk.nextToken();
            if (isNumber(a)) {
                x.stack2.setText(x.stack2.getText() + "   pushing " + a + " to stack\n");
                st.push(a);
                repStack();
                moveShm();
                delay(2000);
            } else {
                moveShm();
                x.stack2.setText(x.stack2.getText() + "   We Got the Operator " + " " + a + "\n");
                repStack();
                delay(2000);
                val1 = Integer.parseInt(st.pop() + "");

                x.stack2.setText(x.stack2.getText() + "   poping " + val1 + " form stack\n");
                repStack();
                delay(2000);
                val2 = Integer.parseInt(st.pop() + "");
                x.stack2.setText(x.stack2.getText() + "   poping " + val2 + " form stack\n");
                repStack();
                delay(2000);
                x.stack2.setText(
                        x.stack2.getText() + "   Finding " + val1 + a + val2 + " = " + res(val2, val1, a) + " \n");
                repStack();
                delay(2000);
                x.stack2.setText(
                        x.stack2.getText() + "   RePush the result " + res(val2, val1, a) + " to the stack \n");
                st.push(res(val2, val1, a));
                repStack();
                delay(2000);
            }
        }
        JOptionPane.showMessageDialog(null, "   The Answer is : " + st.pop());
        x.shm.setVisible(false);

    }

    public void repStack() {
        x.stack1.setText("");
        Istack<String> temp = new Istack<>();
        for (int i = 0; i < st.arr.size; i++) {
            temp.push(st.arr.get(i));
        }

        while (temp.arr.size != 0) {
            x.stack1.setText(x.stack1.getText() + "  " + temp.pop() + "\n");
        }

    }

    public void delay(int del) {
        del = x.slider.getValue();
        try {
            Thread.sleep(del);
        } catch (Exception ex) {

        }
    }

    private boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception sf) {
            return false;
        }
        return true;
    }

    private String res(int n1, int n2, String a) {
        if (a.equals("+")) {
            return (n1 + n2) + "";
        }
        if (a.equals("-")) {
            return (n1 - n2) + "";
        }
        if (a.equals("*")) {
            return (n1 * n2) + "";
        }
        if (a.equals("/") && n2 != 0) {
            return (n1 / n2) + "";
        } else {
            return "Error :3 ";
        }
    }

    public void moveShm() {
        x.shm.setLocation(5 + b.indexOf(" ") * 10 - 5, -10);
        String a = "";
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) != ' ') {
                a += b.charAt(i);
            } else {
                a += ".";
                b = a + b.substring(i + 1);
                break;

            }
        }
    }
}
