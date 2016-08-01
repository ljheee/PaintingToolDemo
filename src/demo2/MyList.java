package demo2;

public class MyList{
	Shape[] arrList = new Shape[0];
	
	/**
	 * 添加元素
	 * @param shape
	 */
	public void addElement(Shape shape){
		
		Shape[] destList = new Shape[arrList.length+1];
		destList[arrList.length] = shape;
		for(int i = 0; i<arrList.length; i++){
			destList[i] = arrList[i];
		}
		//交换
	  arrList = destList;	
		
	}

	/**
	 * 得到元素
	 * @param index
	 * @return
	 */
	public Shape getElement(int index){
		return arrList[index];
	}

	/**
	 * 得到数组长度
	 * @return
	 */
	public int getLength(){
		return arrList.length;
	}
	
}