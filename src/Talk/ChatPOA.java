package Talk;


/**
* Talk/ChatPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Talk.idl
* jeudi 3 novembre 2016 18 h 40 CET
*/

public abstract class ChatPOA extends org.omg.PortableServer.Servant
 implements Talk.ChatOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("inscription", new java.lang.Integer (0));
    _methods.put ("diffusion", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // Talk/Chat/inscription
       {
         Talk.AfficherMessage client = Talk.AfficherMessageHelper.read (in);
         this.inscription (client);
         out = $rh.createReply();
         break;
       }

       case 1:  // Talk/Chat/diffusion
       {
         String message = in.read_string ();
         this.diffusion (message);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Talk/Chat:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Chat _this() 
  {
    return ChatHelper.narrow(
    super._this_object());
  }

  public Chat _this(org.omg.CORBA.ORB orb) 
  {
    return ChatHelper.narrow(
    super._this_object(orb));
  }


} // class ChatPOA
