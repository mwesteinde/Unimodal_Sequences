package unimodal;

public class UnimodalSequence {

	/**
	 * Determine the length of the longest unimodal sequence in intArray
	 * 
	 * @param intArray
	 *            is not null
	 * @return the length of the longest unimodal sequence in intArray
	 * @throws NoUnimodalSequenceException
	 *             if there is no unimodal sequence in intArray
	 */
	public static int getLength_longestUnimodalSequence(int[] intArray) throws NoUnimodalSequenceException {
		int count = 0;
		int max = 0;

		for (int i = 0; i < intArray.length - 1; i++) {
			if (intArray[i] < intArray[i + 1]) {
				count++;
				if (i +1 == intArray.length - 1) {
					count = 0;
					break;
				}
			} else if (count != 0 && intArray[i] > intArray[i + 1]) {
				for (int j = i; j < intArray.length - 1; j++) {
					if (intArray[j] > intArray[j+1]) {
						count++;
						i++;
						if ((j+1) == intArray.length - 1) {
							count ++;
						}
					} else {
						count ++;
						i--;
						break;
					}
				}
				if (count > max) {
					max = count;
				}
				count = 0;
			} else {
				count = 0;
			}
		}
		if (count > max) {
			max = count;
		}
		if (max == 0) {
			throw new NoUnimodalSequenceException();
		}
		return max; // change this
	}

}
