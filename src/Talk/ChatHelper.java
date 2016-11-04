package Talk;


/**
* Talk/ChatHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Talk.idl
* jeudi 3 novembre 2016 18 h 40 CET
*/

abstract public class ChatHelper
{
  private static String  _id = "IDL:Talk/Chat:1.0";

  public static void insert (org.omg.CORBA.Any a, Talk.Chat that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Talk.Chat extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (Talk.ChatHelper.id (), "Chat");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Talk.Chat read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ChatStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Talk.Chat value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static Talk.Chat narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Talk.Chat)
      return (Talk.Chat)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Talk._ChatStub stub = new Talk._ChatStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static Talk.Chat unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Talk.Chat)
      return (Talk.Chat)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Talk._ChatStub stub = new Talk._ChatStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
