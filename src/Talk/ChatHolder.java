package Talk;

/**
* Talk/ChatHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Talk.idl
* jeudi 3 novembre 2016 18 h 40 CET
*/

public final class ChatHolder implements org.omg.CORBA.portable.Streamable
{
  public Talk.Chat value = null;

  public ChatHolder ()
  {
  }

  public ChatHolder (Talk.Chat initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Talk.ChatHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Talk.ChatHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Talk.ChatHelper.type ();
  }

}