package aiso.sim.instructions;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A list of instructions
 * 
 * @author Herve Paulino
 *
 */
public class InstructionList extends ArrayList<Instruction> {
	
	/**
	 * A "restartable" iterator over a list of instructions
	 * 
	 * @author Herve Paulino
	 *
	 */
	public class InstructionListIterator implements Iterator<Instruction> {

		/**
		 * Pointer to the original "not-restartable" iterator provided by ArrayList
		 */
		private Iterator<Instruction> iterator;
		
		/**
		 * A reference to the list of instructions to iterate upon
		 */
		private final InstructionList instructionList;
		
		/**
		 * A "restartable" iterator over a given list of instructions 
		 * @param instructionList The list of instructions 
		 */
		InstructionListIterator(InstructionList instructionList) {
			this.instructionList = instructionList;
			restart();
		}
		
		@Override
		public boolean hasNext() {
			return this.iterator.hasNext();
		}

		@Override
		public Instruction next() {
			return this.iterator.next();
		}

		@Override
		public void remove() {
			this.iterator.remove();
		}
		
		/**
		 * Restart the iterator so that that list of instructions may be re-iterated
		 */
		public void restart() {
			this.iterator = this.instructionList.baseIterator();
		}
		
	}
	
	/**
	 * Default serial version id
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public InstructionListIterator iterator() {
		return new InstructionListIterator(this);
	}
	
	/**
	 * Obtain the iterator implementation of the base class
	 * @return The base iterator
	 */
	private Iterator<Instruction> baseIterator() {
		return super.iterator();
	}
	

}
