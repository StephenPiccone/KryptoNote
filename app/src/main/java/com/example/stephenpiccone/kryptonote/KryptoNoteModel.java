package com.example.stephenpiccone.kryptonote;


public class KryptoNoteModel
{
    private String key;
    public final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String note;

    public KryptoNoteModel(String key, String note)
    {
        this.key=key;
        this.note = note.toUpperCase();

    }
//Note is the msg to be coded
    private String makePad(String note)
    {
        String pad = this.key;
        for (; pad.length() < note.length(); )
            {
                pad += this.key;
            }
        return pad;
    }

    public String encrypt()
    {
        String pad = makePad(note);
        String result = "";
        for(int i = 0; i < note.length(); i++)
            {
                String c = note.substring(i,i+1);
                int position = ALPHABET.indexOf(c);
                int shift = Integer.parseInt(pad.substring(i, i+1));
                int newPosition = (position + shift) % ALPHABET.length();
                result = result + ALPHABET.substring(newPosition, newPosition+1);
            }
            return result;
    }

    public String decrypt()
    {
        String pad = makePad(note);
        String result = "";
        for(int i = 0; i < note.length(); i++)
        {
            String c = note.substring(i,i+1);
            int position = ALPHABET.indexOf(c);
            int shift = Integer.parseInt(pad.substring(i, i+1));
            int newPosition = (position-shift);
            if(newPosition < 0)
            {
                newPosition= newPosition + ALPHABET.length();
                result = result + ALPHABET.substring(newPosition, newPosition+1);
            }
            else
                {
                result = result + ALPHABET.substring(newPosition, newPosition + 1);
                }

        }
        return result;
    }


    public static void main(String[] args)
    {
        KryptoNoteModel myModel;
        myModel = new KryptoNoteModel("613", "BUYTENRBC");
        System.out.println(myModel.encrypt());
        System.out.println(myModel.makePad("BUYTENRBC"));
        myModel = new KryptoNoteModel("613", "HVBZFQXCF");
        System.out.println(myModel.decrypt());


    }
}
