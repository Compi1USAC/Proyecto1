
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package Analizadores;

import java.util.*;
import java_cup.runtime.Symbol;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class SintacticoCSS extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return Symc.class;
}

  /** Default constructor. */
  @Deprecated
  public SintacticoCSS() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public SintacticoCSS(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public SintacticoCSS(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\012\000\002\002\004\000\002\002\012\000\002\003" +
    "\004\000\002\003\003\000\002\004\003\000\002\005\012" +
    "\000\002\007\004\000\002\007\003\000\002\007\004\000" +
    "\002\010\012" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\042\000\004\014\004\001\002\000\004\004\007\001" +
    "\002\000\004\002\006\001\002\000\004\002\001\001\002" +
    "\000\004\015\010\001\002\000\004\014\011\001\002\000" +
    "\004\005\017\001\002\000\004\014\ufffe\001\002\000\004" +
    "\014\ufffd\001\002\000\004\014\015\001\002\000\006\005" +
    "\017\016\020\001\002\000\004\014\uffff\001\002\000\004" +
    "\015\023\001\002\000\004\004\021\001\002\000\004\015" +
    "\022\001\002\000\004\002\000\001\002\000\006\003\024" +
    "\014\025\001\002\000\004\015\044\001\002\000\004\006" +
    "\032\001\002\000\004\014\ufffa\001\002\000\004\014\030" +
    "\001\002\000\006\006\032\016\033\001\002\000\004\014" +
    "\ufffb\001\002\000\004\015\036\001\002\000\004\005\034" +
    "\001\002\000\004\015\035\001\002\000\004\014\ufffc\001" +
    "\002\000\004\020\037\001\002\000\004\014\040\001\002" +
    "\000\004\016\041\001\002\000\004\006\042\001\002\000" +
    "\004\015\043\001\002\000\004\014\ufff8\001\002\000\004" +
    "\014\ufff9\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\042\000\004\002\004\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\010" +
    "\003\013\004\011\005\012\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\006\004\015\005\012" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\006\007\026\010\025\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\010\030\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$SintacticoCSS$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$SintacticoCSS$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$SintacticoCSS$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  
    /*public static LinkedList<AcepErr> TablaErr=new LinkedList<AcepErr>();*/

    public String resultado = "";
    //Metodo al que se llama automaticamente ante algun error sintactico
    public void syntax_error(Symbol s)
    {        
        String lexema = s.value.toString();
        int fila = s.right;
        int columna = s.left;
        
        System.out.println("!!!!!!! Error Sintactico Recuperado !!!!!!!");
        System.out.println("\t\tLexema: "+lexema);
        System.out.println("\t\tFila: "+fila);
        System.out.println("\t\tColumna: "+columna);

        //lista_errores.add(new ErrorT(lexema, fila, columna,"sintactico" ,"Simbolo no esperado"));
        /*AcepErr datos =new AcepErr(lexema, "ERROR SINTACTICO" ,fila,columna,"Simbolo no esperado");
            TablaErr.add(datos);
            */
    }

    //Metodo al que se llama en el momento en que ya no es posible una recuperacion de errores
    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception
    {        
        String lexema = s.value.toString();
        int fila = s.right;
        int columna = s.left;
        
        System.out.println("!!!!!!! Error Sintactico, Panic Mode !!!!!!! ");
        System.out.println("\t\tLexema: "+lexema);
        System.out.println("\t\tFila: "+fila);
        System.out.println("\t\tColumna: "+columna);

       /*AcepErr datos =new AcepErr(lexema, "ERROR SINTACTICO" ,fila,columna,"Simbolo no esperado Error Fatal");
                   TablaErr.add(datos);
                  */
        //lista_errores.add(new ErrorT(lexema, fila, columna,"sintactico" ,"Simbolo no esperado, Panic Mode"));
    }

    public void semantic(Symbol cur_token, String n) 
    {
        System.out.println("error semantico ");
    }

    public void semantic(String msg, Object obj) {}



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$SintacticoCSS$actions {




  private final SintacticoCSS parser;

  /** Constructor */
  CUP$SintacticoCSS$actions(SintacticoCSS parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$SintacticoCSS$do_action_part00000000(
    int                        CUP$SintacticoCSS$act_num,
    java_cup.runtime.lr_parser CUP$SintacticoCSS$parser,
    java.util.Stack            CUP$SintacticoCSS$stack,
    int                        CUP$SintacticoCSS$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$SintacticoCSS$result;

      /* select the action based on the action number */
      switch (CUP$SintacticoCSS$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= INICIO EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$SintacticoCSS$stack.elementAt(CUP$SintacticoCSS$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$SintacticoCSS$stack.elementAt(CUP$SintacticoCSS$top-1)).right;
		String start_val = (String)((java_cup.runtime.Symbol) CUP$SintacticoCSS$stack.elementAt(CUP$SintacticoCSS$top-1)).value;
		RESULT = start_val;
              CUP$SintacticoCSS$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$SintacticoCSS$stack.elementAt(CUP$SintacticoCSS$top-1)), ((java_cup.runtime.Symbol)CUP$SintacticoCSS$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$SintacticoCSS$parser.done_parsing();
          return CUP$SintacticoCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // INICIO ::= tMenorQue tHtml tMayorQue LISTAHTML tMenorQue tDiagonal tHtml tMayorQue 
            {
              String RESULT =null;
		 
              CUP$SintacticoCSS$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$SintacticoCSS$stack.elementAt(CUP$SintacticoCSS$top-7)), ((java_cup.runtime.Symbol)CUP$SintacticoCSS$stack.peek()), RESULT);
            }
          return CUP$SintacticoCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // LISTAHTML ::= LISTAHTML ITEMHTML 
            {
              String RESULT =null;

              CUP$SintacticoCSS$result = parser.getSymbolFactory().newSymbol("LISTAHTML",1, ((java_cup.runtime.Symbol)CUP$SintacticoCSS$stack.elementAt(CUP$SintacticoCSS$top-1)), ((java_cup.runtime.Symbol)CUP$SintacticoCSS$stack.peek()), RESULT);
            }
          return CUP$SintacticoCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // LISTAHTML ::= ITEMHTML 
            {
              String RESULT =null;

              CUP$SintacticoCSS$result = parser.getSymbolFactory().newSymbol("LISTAHTML",1, ((java_cup.runtime.Symbol)CUP$SintacticoCSS$stack.peek()), ((java_cup.runtime.Symbol)CUP$SintacticoCSS$stack.peek()), RESULT);
            }
          return CUP$SintacticoCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // ITEMHTML ::= HEAD 
            {
              String RESULT =null;

              CUP$SintacticoCSS$result = parser.getSymbolFactory().newSymbol("ITEMHTML",2, ((java_cup.runtime.Symbol)CUP$SintacticoCSS$stack.peek()), ((java_cup.runtime.Symbol)CUP$SintacticoCSS$stack.peek()), RESULT);
            }
          return CUP$SintacticoCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // HEAD ::= tMenorQue tHead tMayorQue LISTAHEAD tMenorQue tDiagonal tHead tMayorQue 
            {
              String RESULT =null;

              CUP$SintacticoCSS$result = parser.getSymbolFactory().newSymbol("HEAD",3, ((java_cup.runtime.Symbol)CUP$SintacticoCSS$stack.elementAt(CUP$SintacticoCSS$top-7)), ((java_cup.runtime.Symbol)CUP$SintacticoCSS$stack.peek()), RESULT);
            }
          return CUP$SintacticoCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // LISTAHEAD ::= LISTAHEAD ITEMHEAD 
            {
              String RESULT =null;

              CUP$SintacticoCSS$result = parser.getSymbolFactory().newSymbol("LISTAHEAD",5, ((java_cup.runtime.Symbol)CUP$SintacticoCSS$stack.elementAt(CUP$SintacticoCSS$top-1)), ((java_cup.runtime.Symbol)CUP$SintacticoCSS$stack.peek()), RESULT);
            }
          return CUP$SintacticoCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // LISTAHEAD ::= ITEMHEAD 
            {
              String RESULT =null;

              CUP$SintacticoCSS$result = parser.getSymbolFactory().newSymbol("LISTAHEAD",5, ((java_cup.runtime.Symbol)CUP$SintacticoCSS$stack.peek()), ((java_cup.runtime.Symbol)CUP$SintacticoCSS$stack.peek()), RESULT);
            }
          return CUP$SintacticoCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // LISTAHEAD ::= error tMayorQue 
            {
              String RESULT =null;

              CUP$SintacticoCSS$result = parser.getSymbolFactory().newSymbol("LISTAHEAD",5, ((java_cup.runtime.Symbol)CUP$SintacticoCSS$stack.elementAt(CUP$SintacticoCSS$top-1)), ((java_cup.runtime.Symbol)CUP$SintacticoCSS$stack.peek()), RESULT);
            }
          return CUP$SintacticoCSS$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // ITEMHEAD ::= tMenorQue tTitle tMayorQue tCadenaInterna tMenorQue tDiagonal tTitle tMayorQue 
            {
              String RESULT =null;

              CUP$SintacticoCSS$result = parser.getSymbolFactory().newSymbol("ITEMHEAD",6, ((java_cup.runtime.Symbol)CUP$SintacticoCSS$stack.elementAt(CUP$SintacticoCSS$top-7)), ((java_cup.runtime.Symbol)CUP$SintacticoCSS$stack.peek()), RESULT);
            }
          return CUP$SintacticoCSS$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$SintacticoCSS$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$SintacticoCSS$do_action(
    int                        CUP$SintacticoCSS$act_num,
    java_cup.runtime.lr_parser CUP$SintacticoCSS$parser,
    java.util.Stack            CUP$SintacticoCSS$stack,
    int                        CUP$SintacticoCSS$top)
    throws java.lang.Exception
    {
              return CUP$SintacticoCSS$do_action_part00000000(
                               CUP$SintacticoCSS$act_num,
                               CUP$SintacticoCSS$parser,
                               CUP$SintacticoCSS$stack,
                               CUP$SintacticoCSS$top);
    }
}

}
