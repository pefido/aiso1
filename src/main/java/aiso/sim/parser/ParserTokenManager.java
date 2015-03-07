/* Generated By:JavaCC: Do not edit this line. ParserTokenManager.java */
package aiso.sim.parser;
import java.util.ArrayList;
import java.util.List;
import aiso.sim.Program;
import aiso.sim.instructions.Instruction;
import aiso.sim.instructions.InstructionFactory;
import aiso.sim.instructions.InstructionList;

/** Token Manager. */
public class ParserTokenManager implements ParserConstants
{

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x3eL) != 0L)
         {
            jjmatchedKind = 8;
            return 5;
         }
         return -1;
      case 1:
         if ((active0 & 0x3eL) != 0L)
         {
            jjmatchedKind = 8;
            jjmatchedPos = 1;
            return 5;
         }
         return -1;
      case 2:
         if ((active0 & 0x3eL) != 0L)
         {
            jjmatchedKind = 8;
            jjmatchedPos = 2;
            return 5;
         }
         return -1;
      case 3:
         if ((active0 & 0x16L) != 0L)
         {
            jjmatchedKind = 8;
            jjmatchedPos = 3;
            return 5;
         }
         if ((active0 & 0x28L) != 0L)
            return 5;
         return -1;
      case 4:
         if ((active0 & 0x6L) != 0L)
         {
            jjmatchedKind = 8;
            jjmatchedPos = 4;
            return 5;
         }
         if ((active0 & 0x10L) != 0L)
            return 5;
         return -1;
      case 5:
         if ((active0 & 0x6L) != 0L)
         {
            jjmatchedKind = 8;
            jjmatchedPos = 5;
            return 5;
         }
         return -1;
      case 6:
         if ((active0 & 0x4L) != 0L)
            return 5;
         if ((active0 & 0x2L) != 0L)
         {
            jjmatchedKind = 8;
            jjmatchedPos = 6;
            return 5;
         }
         return -1;
      case 7:
         if ((active0 & 0x2L) != 0L)
         {
            jjmatchedKind = 8;
            jjmatchedPos = 7;
            return 5;
         }
         return -1;
      case 8:
         if ((active0 & 0x2L) != 0L)
         {
            jjmatchedKind = 8;
            jjmatchedPos = 8;
            return 5;
         }
         return -1;
      case 9:
         if ((active0 & 0x2L) != 0L)
         {
            jjmatchedKind = 8;
            jjmatchedPos = 9;
            return 5;
         }
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 60:
         return jjStopAtPos(0, 15);
      case 62:
         return jjStopAtPos(0, 16);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x2L);
      case 108:
         return jjMoveStringLiteralDfa1_0(0x28L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x14L);
      case 123:
         return jjStopAtPos(0, 17);
      case 125:
         return jjStopAtPos(0, 18);
      default :
         return jjMoveNfa_0(1, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x2aL);
      case 116:
         return jjMoveStringLiteralDfa2_0(active0, 0x10L);
      case 121:
         return jjMoveStringLiteralDfa2_0(active0, 0x4L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x8L);
      case 109:
         return jjMoveStringLiteralDfa3_0(active0, 0x2L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x30L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x4L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 99:
         return jjMoveStringLiteralDfa4_0(active0, 0x4L);
      case 100:
         if ((active0 & 0x8L) != 0L)
            return jjStartNfaWithStates_0(3, 3, 5);
         break;
      case 112:
         if ((active0 & 0x20L) != 0L)
            return jjStartNfaWithStates_0(3, 5, 5);
         return jjMoveStringLiteralDfa4_0(active0, 0x2L);
      case 114:
         return jjMoveStringLiteralDfa4_0(active0, 0x10L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0x4L);
      case 101:
         if ((active0 & 0x10L) != 0L)
            return jjStartNfaWithStates_0(4, 4, 5);
         break;
      case 117:
         return jjMoveStringLiteralDfa5_0(active0, 0x2L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 108:
         return jjMoveStringLiteralDfa6_0(active0, 0x4L);
      case 116:
         return jjMoveStringLiteralDfa6_0(active0, 0x2L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
private int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa7_0(active0, 0x2L);
      case 108:
         if ((active0 & 0x4L) != 0L)
            return jjStartNfaWithStates_0(6, 2, 5);
         break;
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
private int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 116:
         return jjMoveStringLiteralDfa8_0(active0, 0x2L);
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
private int jjMoveStringLiteralDfa8_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0);
      return 8;
   }
   switch(curChar)
   {
      case 105:
         return jjMoveStringLiteralDfa9_0(active0, 0x2L);
      default :
         break;
   }
   return jjStartNfa_0(7, active0);
}
private int jjMoveStringLiteralDfa9_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(7, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(8, active0);
      return 9;
   }
   switch(curChar)
   {
      case 111:
         return jjMoveStringLiteralDfa10_0(active0, 0x2L);
      default :
         break;
   }
   return jjStartNfa_0(8, active0);
}
private int jjMoveStringLiteralDfa10_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(8, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(9, active0);
      return 10;
   }
   switch(curChar)
   {
      case 110:
         if ((active0 & 0x2L) != 0L)
            return jjStartNfaWithStates_0(10, 1, 5);
         break;
      default :
         break;
   }
   return jjStartNfa_0(9, active0);
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0xfff0000000200002L, 0xffffffffffffdfffL, 0xfffff00f7fffffffL, 0x12000000007fffffL
};
static final long[] jjbitVec2 = {
   0x0L, 0x0L, 0x420043c00000000L, 0xff7fffffff7fffffL
};
static final long[] jjbitVec3 = {
   0xffffcffffffffL, 0xffffffffffff0000L, 0xf9ff3fffffffffffL, 0x401f00030003L
};
static final long[] jjbitVec4 = {
   0x0L, 0x400000000000000L, 0xfffffffbffffd740L, 0xffffffcff7fffL
};
static final long[] jjbitVec5 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0xfffffffffffff003L, 0x33fffffffff199fL
};
static final long[] jjbitVec6 = {
   0xfffe000000000000L, 0xfffffffe027fffffL, 0xffL, 0x707ffffff0000L
};
static final long[] jjbitVec7 = {
   0x7fffffe00000000L, 0xfffe0000000007ffL, 0xffffffffffffffffL, 0x1c000060002fffffL
};
static final long[] jjbitVec8 = {
   0x1ffffffd0000L, 0x0L, 0x3fffffffffL, 0x0L
};
static final long[] jjbitVec9 = {
   0x23ffffffffffffe0L, 0x3ff010000L, 0x3c5fdfffff99fe0L, 0xf0003b0000000L
};
static final long[] jjbitVec10 = {
   0x36dfdfffff987e0L, 0x1c00005e000000L, 0x23edfdfffffbafe0L, 0x100010000L
};
static final long[] jjbitVec11 = {
   0x23cdfdfffff99fe0L, 0x3b0000000L, 0x3bfc718d63dc7e0L, 0x0L
};
static final long[] jjbitVec12 = {
   0x3effdfffffddfe0L, 0x300000000L, 0x3effdfffffddfe0L, 0x340000000L
};
static final long[] jjbitVec13 = {
   0x3fffdfffffddfe0L, 0x300000000L, 0x2ffbfffffc7fffe0L, 0x7fL
};
static final long[] jjbitVec14 = {
   0x800dfffffffffffeL, 0x7fL, 0x200decaefef02596L, 0x3000005fL
};
static final long[] jjbitVec15 = {
   0x1L, 0x7fffffffeffL, 0xf00L, 0x0L
};
static final long[] jjbitVec16 = {
   0x6fbffffffffL, 0x3f0000L, 0xffffffff00000000L, 0x7fffffffff003fL
};
static final long[] jjbitVec17 = {
   0xffffffffffffffffL, 0xffffffff83ffffffL, 0xffffff07ffffffffL, 0x3ffffffffffffffL
};
static final long[] jjbitVec18 = {
   0xffffffffffffff7fL, 0xffffffff3d7f3d7fL, 0x7f3d7fffffff3d7fL, 0xffff7fffff7f7f3dL
};
static final long[] jjbitVec19 = {
   0xffffffff7f3d7fffL, 0x7ffff7fL, 0xffffffff00000000L, 0x1fffffffffffffL
};
static final long[] jjbitVec20 = {
   0xfffffffffffffffeL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec21 = {
   0xffffffffffffffffL, 0x7f9fffffffffffL, 0xffffffff07fffffeL, 0x7ffffffffffL
};
static final long[] jjbitVec22 = {
   0x0L, 0x0L, 0xfffffffffffffL, 0x8000000L
};
static final long[] jjbitVec23 = {
   0xffffffff00000000L, 0xffffffffffffffL, 0x1ffffffffffL, 0x0L
};
static final long[] jjbitVec24 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffff0fffffffL, 0x3ffffffffffffffL
};
static final long[] jjbitVec25 = {
   0xffffffff3f3fffffL, 0x3fffffffaaff3f3fL, 0x5fdfffffffffffffL, 0x1fdc1fff0fcf1fdcL
};
static final long[] jjbitVec26 = {
   0x8000000000000000L, 0x8000000000000001L, 0xffff00000000L, 0x0L
};
static final long[] jjbitVec27 = {
   0x3fbbd503e2ffc84L, 0xffffffff00000000L, 0xfL, 0x0L
};
static final long[] jjbitVec28 = {
   0x73e03fe000000e0L, 0xfffffffffffffffeL, 0xfffffffe601fffffL, 0x7fffffffffffffffL
};
static final long[] jjbitVec29 = {
   0xfffe1fffffffffe0L, 0xffffffffffffffffL, 0xffffff00007fffL, 0x0L
};
static final long[] jjbitVec30 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0x3fffffffffffffL, 0x0L
};
static final long[] jjbitVec31 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0x3fffffffffL, 0x0L
};
static final long[] jjbitVec32 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0x1fffL, 0x0L
};
static final long[] jjbitVec33 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0xfffffffffL, 0x0L
};
static final long[] jjbitVec34 = {
   0x3fffffffffffL, 0x0L, 0x0L, 0x0L
};
static final long[] jjbitVec35 = {
   0x5f7ffdffa0f8007fL, 0xffffffffffffffdbL, 0x3ffffffffffffL, 0xfffffffffff80000L
};
static final long[] jjbitVec36 = {
   0x3fffffffffffffffL, 0xffffffffffff0000L, 0xfffffffffffcffffL, 0xfff0000000000ffL
};
static final long[] jjbitVec37 = {
   0x18000000000000L, 0xffd702000000e000L, 0xffffffffffffffffL, 0x1fffffffffffffffL
};
static final long[] jjbitVec38 = {
   0x87fffffe00000010L, 0xffffffe007fffffeL, 0x7fffffffffffffffL, 0x631cfcfcfcL
};
static final long[] jjbitVec39 = {
   0x0L, 0x0L, 0x420043cffffffffL, 0xff7fffffff7fffffL
};
static final long[] jjbitVec40 = {
   0xffffffffffffffffL, 0x400000700007fffL, 0xfffffffbffffd740L, 0xffffffcff7fffL
};
static final long[] jjbitVec41 = {
   0xffffffffffffffffL, 0xffffffffffffffffL, 0xfffffffffffff07bL, 0x33fffffffff199fL
};
static final long[] jjbitVec42 = {
   0xfffe000000000000L, 0xfffffffe027fffffL, 0xbbfffffbfffe00ffL, 0x707ffffff0016L
};
static final long[] jjbitVec43 = {
   0x7fffffe00000000L, 0xffff03ff003fffffL, 0xffffffffffffffffL, 0x1fff3dff9fefffffL
};
static final long[] jjbitVec44 = {
   0xffff1fffffff8000L, 0x7ffL, 0x1ffffffffffffL, 0x0L
};
static final long[] jjbitVec45 = {
   0xf3ffffffffffffeeL, 0xffcfff1f3fffL, 0xd3c5fdfffff99feeL, 0xfffcfb080399fL
};
static final long[] jjbitVec46 = {
   0xd36dfdfffff987e4L, 0x1fffc05e003987L, 0xf3edfdfffffbafeeL, 0xffc100013bbfL
};
static final long[] jjbitVec47 = {
   0xf3cdfdfffff99feeL, 0xffc3b0c0398fL, 0xc3bfc718d63dc7ecL, 0xff8000803dc7L
};
static final long[] jjbitVec48 = {
   0xc3effdfffffddfeeL, 0xffc300603ddfL, 0xc3effdfffffddfecL, 0xffc340603ddfL
};
static final long[] jjbitVec49 = {
   0xc3fffdfffffddfecL, 0xffc300803dcfL, 0x2ffbfffffc7fffecL, 0xc0000ff5f847fL
};
static final long[] jjbitVec50 = {
   0x87fffffffffffffeL, 0x3ff7fffL, 0x3bffecaefef02596L, 0x33ff3f5fL
};
static final long[] jjbitVec51 = {
   0xc2a003ff03000001L, 0xfffe07fffffffeffL, 0x1ffffffffeff0fdfL, 0x40L
};
static final long[] jjbitVec52 = {
   0x3c7f6fbffffffffL, 0x3ff03ffL, 0xffffffff00000000L, 0x7fffffffff003fL
};
static final long[] jjbitVec53 = {
   0xffffffff7f3d7fffL, 0x3fe0007ffff7fL, 0xffffffff00000000L, 0x1fffffffffffffL
};
static final long[] jjbitVec54 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0x3ff080fffffL
};
static final long[] jjbitVec55 = {
   0xffffffff03ff7800L, 0xffffffffffffffL, 0x3ffffffffffL, 0x0L
};
static final long[] jjbitVec56 = {
   0x80007c000000f000L, 0x8000fc0000000001L, 0xffff00000000L, 0x21fff0000L
};
static final long[] jjbitVec57 = {
   0x73efffe000000e0L, 0xfffffffffffffffeL, 0xfffffffe661fffffL, 0x7fffffffffffffffL
};
static final long[] jjbitVec58 = {
   0x5f7ffdffe0f8007fL, 0xffffffffffffffdbL, 0x3ffffffffffffL, 0xfffffffffff80000L
};
static final long[] jjbitVec59 = {
   0x18000f00000000L, 0xffd702000000e000L, 0xffffffffffffffffL, 0x9fffffffffffffffL
};
static final long[] jjbitVec60 = {
   0x87fffffe03ff0010L, 0xffffffe007fffffeL, 0x7fffffffffffffffL, 0xe0000631cfcfcfcL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 6;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 6)
                        kind = 6;
                     jjCheckNAdd(0);
                  }
                  else if (curChar == 36)
                  {
                     if (kind > 8)
                        kind = 8;
                     jjCheckNAdd(5);
                  }
                  if (curChar == 48)
                     jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 0:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 6)
                     kind = 6;
                  jjCheckNAdd(0);
                  break;
               case 3:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 7)
                     kind = 7;
                  jjstateSet[jjnewStateCnt++] = 3;
                  break;
               case 4:
                  if (curChar != 36)
                     break;
                  if (kind > 8)
                     kind = 8;
                  jjCheckNAdd(5);
                  break;
               case 5:
                  if ((0x3ff00100fffc1ffL & l) == 0L)
                     break;
                  if (kind > 8)
                     kind = 8;
                  jjCheckNAdd(5);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 8)
                     kind = 8;
                  jjCheckNAdd(5);
                  break;
               case 2:
                  if ((0x100000001000000L & l) != 0L)
                     jjCheckNAdd(3);
                  break;
               case 3:
                  if ((0x7e0000007eL & l) == 0L)
                     break;
                  if (kind > 7)
                     kind = 7;
                  jjCheckNAdd(3);
                  break;
               case 5:
                  if ((0x87fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 8)
                     kind = 8;
                  jjCheckNAdd(5);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (int)(curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
                  if (!jjCanMove_0(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 8)
                     kind = 8;
                  jjCheckNAdd(5);
                  break;
               case 5:
                  if (!jjCanMove_1(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 8)
                     kind = 8;
                  jjCheckNAdd(5);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 6 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
};
private static final boolean jjCanMove_0(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec2[i2] & l2) != 0L);
      case 2:
         return ((jjbitVec3[i2] & l2) != 0L);
      case 3:
         return ((jjbitVec4[i2] & l2) != 0L);
      case 4:
         return ((jjbitVec5[i2] & l2) != 0L);
      case 5:
         return ((jjbitVec6[i2] & l2) != 0L);
      case 6:
         return ((jjbitVec7[i2] & l2) != 0L);
      case 7:
         return ((jjbitVec8[i2] & l2) != 0L);
      case 9:
         return ((jjbitVec9[i2] & l2) != 0L);
      case 10:
         return ((jjbitVec10[i2] & l2) != 0L);
      case 11:
         return ((jjbitVec11[i2] & l2) != 0L);
      case 12:
         return ((jjbitVec12[i2] & l2) != 0L);
      case 13:
         return ((jjbitVec13[i2] & l2) != 0L);
      case 14:
         return ((jjbitVec14[i2] & l2) != 0L);
      case 15:
         return ((jjbitVec15[i2] & l2) != 0L);
      case 16:
         return ((jjbitVec16[i2] & l2) != 0L);
      case 17:
         return ((jjbitVec17[i2] & l2) != 0L);
      case 18:
         return ((jjbitVec18[i2] & l2) != 0L);
      case 19:
         return ((jjbitVec19[i2] & l2) != 0L);
      case 20:
         return ((jjbitVec20[i2] & l2) != 0L);
      case 22:
         return ((jjbitVec21[i2] & l2) != 0L);
      case 23:
         return ((jjbitVec22[i2] & l2) != 0L);
      case 24:
         return ((jjbitVec23[i2] & l2) != 0L);
      case 30:
         return ((jjbitVec24[i2] & l2) != 0L);
      case 31:
         return ((jjbitVec25[i2] & l2) != 0L);
      case 32:
         return ((jjbitVec26[i2] & l2) != 0L);
      case 33:
         return ((jjbitVec27[i2] & l2) != 0L);
      case 48:
         return ((jjbitVec28[i2] & l2) != 0L);
      case 49:
         return ((jjbitVec29[i2] & l2) != 0L);
      case 77:
         return ((jjbitVec30[i2] & l2) != 0L);
      case 159:
         return ((jjbitVec31[i2] & l2) != 0L);
      case 164:
         return ((jjbitVec32[i2] & l2) != 0L);
      case 215:
         return ((jjbitVec33[i2] & l2) != 0L);
      case 250:
         return ((jjbitVec34[i2] & l2) != 0L);
      case 251:
         return ((jjbitVec35[i2] & l2) != 0L);
      case 253:
         return ((jjbitVec36[i2] & l2) != 0L);
      case 254:
         return ((jjbitVec37[i2] & l2) != 0L);
      case 255:
         return ((jjbitVec38[i2] & l2) != 0L);
      default :
         if ((jjbitVec0[i1] & l1) != 0L)
            return true;
         return false;
   }
}
private static final boolean jjCanMove_1(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec39[i2] & l2) != 0L);
      case 2:
         return ((jjbitVec3[i2] & l2) != 0L);
      case 3:
         return ((jjbitVec40[i2] & l2) != 0L);
      case 4:
         return ((jjbitVec41[i2] & l2) != 0L);
      case 5:
         return ((jjbitVec42[i2] & l2) != 0L);
      case 6:
         return ((jjbitVec43[i2] & l2) != 0L);
      case 7:
         return ((jjbitVec44[i2] & l2) != 0L);
      case 9:
         return ((jjbitVec45[i2] & l2) != 0L);
      case 10:
         return ((jjbitVec46[i2] & l2) != 0L);
      case 11:
         return ((jjbitVec47[i2] & l2) != 0L);
      case 12:
         return ((jjbitVec48[i2] & l2) != 0L);
      case 13:
         return ((jjbitVec49[i2] & l2) != 0L);
      case 14:
         return ((jjbitVec50[i2] & l2) != 0L);
      case 15:
         return ((jjbitVec51[i2] & l2) != 0L);
      case 16:
         return ((jjbitVec52[i2] & l2) != 0L);
      case 17:
         return ((jjbitVec17[i2] & l2) != 0L);
      case 18:
         return ((jjbitVec18[i2] & l2) != 0L);
      case 19:
         return ((jjbitVec53[i2] & l2) != 0L);
      case 20:
         return ((jjbitVec20[i2] & l2) != 0L);
      case 22:
         return ((jjbitVec21[i2] & l2) != 0L);
      case 23:
         return ((jjbitVec54[i2] & l2) != 0L);
      case 24:
         return ((jjbitVec55[i2] & l2) != 0L);
      case 30:
         return ((jjbitVec24[i2] & l2) != 0L);
      case 31:
         return ((jjbitVec25[i2] & l2) != 0L);
      case 32:
         return ((jjbitVec56[i2] & l2) != 0L);
      case 33:
         return ((jjbitVec27[i2] & l2) != 0L);
      case 48:
         return ((jjbitVec57[i2] & l2) != 0L);
      case 49:
         return ((jjbitVec29[i2] & l2) != 0L);
      case 77:
         return ((jjbitVec30[i2] & l2) != 0L);
      case 159:
         return ((jjbitVec31[i2] & l2) != 0L);
      case 164:
         return ((jjbitVec32[i2] & l2) != 0L);
      case 215:
         return ((jjbitVec33[i2] & l2) != 0L);
      case 250:
         return ((jjbitVec34[i2] & l2) != 0L);
      case 251:
         return ((jjbitVec58[i2] & l2) != 0L);
      case 253:
         return ((jjbitVec36[i2] & l2) != 0L);
      case 254:
         return ((jjbitVec59[i2] & l2) != 0L);
      case 255:
         return ((jjbitVec60[i2] & l2) != 0L);
      default :
         if ((jjbitVec0[i1] & l1) != 0L)
            return true;
         return false;
   }
}

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", "\143\157\155\160\165\164\141\164\151\157\156", 
"\163\171\163\143\141\154\154", "\154\157\141\144", "\163\164\157\162\145", "\154\157\157\160", null, null, 
null, null, null, null, null, null, null, "\74", "\76", "\173", "\175", };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0x781ffL, 
};
static final long[] jjtoSkip = {
   0x7800L, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[6];
private final int[] jjstateSet = new int[12];
protected char curChar;
/** Constructor. */
public ParserTokenManager(SimpleCharStream stream){
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor. */
public ParserTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 6; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

}
