abstract class GenericMatrix<E extends Number>{  
    //������Ԫ����ӵĳ��󷽷�;
    protected abstract E add(E o1, E o2);
    //�����������Ԫ����˵ĳ��󷽷�
    protected abstract E multiply(E o1, E o2);
    //���������ĳ��󷽷�
    protected abstract E zero(); 
    
    //�������������,�÷���E����ʾ�࣬���Է����ǷǾ�̬�ģ�
    public E[][] addMatrix(E[][] matrix1, E[][] matrix2){  
        if ((matrix1.length != matrix2.length) || (matrix1[0].length != matrix2[0].length)){  
            throw new RuntimeException("The matrices do not have the same size!");  
        }
        //ע��E[][] result = new Number[matrix.length][matrix1[0].length]�ǲ��Եģ�
        //��Ϊ�����÷����������������飬Ҫ�ã�E[][]����ת�����ܴ������飻
        //������matrix1�;���matrix2�Ĵ�С�Ƿ����,matrix1.lengthΪ������matrix1[0].lengthΪ����
        E[][] result = (E[][])new Number[matrix1.length][matrix1[0].length];  
        for(int i=0;i<result.length;i++) 
            for(int j=0;j<result[i].length;j++) {
                result[i][j]=add(matrix1[i][j],matrix2[i][j]);
            }
        return result;             
    }
    public E[][] multiplyMatrix(E[][] matrix1, E[][] matrix2){
        if (matrix1[0].length != matrix2.length){  
            throw new RuntimeException("The matrices do not have the same size!");  
        }
        E[][] result = (E[][])new Number[matrix1.length][matrix2[0].length];  
        for(int i=0;i<result.length;i++) {
            for(int j=0;j<result[0].length;j++) {
                result[i][j]=zero();
                for(int k=0;k<matrix1[0].length;k++) {
                    result[i][j]=add(result[i][j],multiply(matrix1[i][k],matrix2[k][j]));
                }
            }
        }
        return result;
    }
    public static void printResult(Number[][] m1,Number[][] m2,Number[][] m3,char op) {
        for(int i=0;i<m1.length;i++) {
            for(int j=0;j<m1[0].length;j++)
                System.out.print(" "+m1[i][j]);
            if(i==m1.length/2)
                System.out.print(" "+op+ " ");
            else
                System.out.print("   ");
            for(int j=0;j<m2.length;j++)
                System.out.print(" "+m2[i][j]);
            if(i==m1.length/2)
                System.out.print(" = ");
            else
                System.out.print("   ");
            for(int j=0;j<m3.length;j++)
                System.out.print(m3[i][j]+" ");
            System.out.println();
        }
    }
}
class IntegerMatrix extends GenericMatrix<Integer>{  
    //ʵ��GenericMatrix�е�add���󷽷�
    protected Integer add(Integer o1, Integer o2 ){  
        return o1+o2;  
    }  
    //ʵ��GenericMatrix�е�mltiply���󷽷�
    protected Integer multiply(Integer o1, Integer o2){  
        return o1*o2;  
    }  
    //ʵ��GenericMatrix�е�zero���󷽷�
    protected Integer zero(){  
        return 0;  
    }  
}  
  
//Double����̳���GenericMatrix<��extends Number>�е�;
class DoubleMatrix extends  GenericMatrix<Double>{  
    //ʵ��GenericMatrix�е��������󷽷��� 
    protected Double add(Double d1,Double d2){  
        return d1+d2;  
    }  
    protected Double multiply(Double d1,Double d2){  
        return d1*d2;  
    }  
    protected Double zero(){  
        return 0.0;  
    }  
  
}  
class CharacterMatrix <Character>{   
    protected Character add(Character r1,Character r2){  
        return r1+r2;  
    }  
    protected Character multiply(Character r1,Character r2){  
        return r1*r2;  
    }  
    protected Character zero(){  
        return 0;  
    }  
  
}  
  
public class testGenericMatrix{  
    public static void main(String[] args){  
        //����Integer����
        Integer[][] m1 = new Integer[][]{{1,2,3},{4,5,6},{7,8,9}};  
        Integer[][] m2 = new Integer[][]{{1,5,1},{2,4,2},{0,0,0}};
        
        //����IntegerMatrixʵ����
        IntegerMatrix integerMatrix = new IntegerMatrix(); 
        
        System.out.println("�����ӷ� ");  
        GenericMatrix.printResult(m1,m2,integerMatrix.addMatrix(m1,m2),'+');  
        
        System.out.println("�����˷� ");  
        GenericMatrix.printResult(m1,m2,integerMatrix.multiplyMatrix(m1,m2),'*'); 
        //����Double����
        Double[][] d1 = new Double[][]{{0.0, 1.0, 2.0}, {1.0, 2.0, 3.0}, {2.0, 3.0, 4.0}};  
        Double[][] d2 = new Double[][]{{0.0, 0.5, 1.0}, {0.5, 1.0, 1.5}, {1.0, 1.5, 2.0}};  
        
        DoubleMatrix doubleMatrix = new DoubleMatrix();  
        
        System.out.println("�������ӷ� ");  
        GenericMatrix.printResult(d1,d2,doubleMatrix.addMatrix(d1,d2),'+');  
        
        System.out.println("�������˷�");  
        GenericMatrix.printResult(d1,d2,doubleMatrix.multiplyMatrix(d1,d2),'*');  
		//����Character����

        Character[][] r1 = new Character[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};  
        Character[][] r2 = new Character[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};  
        
        CharacterMatrix characterMatrix = new CharacterMatrix();  
        
        System.out.println("�ַ��ӷ� ");  
        CharacterMatrix.printResult(r1,r2,characterMatrix.addMatrix(r1,r2),'+');  
        
        System.out.println("�ַ��˷�");  
        CharacterMatrix.printResult(r1,r2,characterMatrix.multiplyMatrix(r1,r2),'*'); 
    }  
  
}  
