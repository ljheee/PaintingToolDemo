package demo2;

public class MyList{
	Shape[] arrList = new Shape[0];
	
	/**
	 * ���Ԫ��
	 * @param shape
	 */
	public void addElement(Shape shape){
		
		Shape[] destList = new Shape[arrList.length+1];
		destList[arrList.length] = shape;
		for(int i = 0; i<arrList.length; i++){
			destList[i] = arrList[i];
		}
		//����
	  arrList = destList;	
		
	}

	/**
	 * �õ�Ԫ��
	 * @param index
	 * @return
	 */
	public Shape getElement(int index){
		return arrList[index];
	}

	/**
	 * �õ����鳤��
	 * @return
	 */
	public int getLength(){
		return arrList.length;
	}
	
}