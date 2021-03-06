package Paint;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Paint extends JPanel{//建立一个很大的数组，用来存放图形元素
  private Shape[] ShArr = new Shape[10000];
  public static void main(String[] args) {
  Paint p = new Paint();
	}

JPanel jp = new JPanel(){//JPanel可以为添加到窗体中的轻型控件提供通用的容器。默认情况下，面板容器不会向控件添加任何除自身背景之外的颜色
	int len = 0;//实例化一个ButtonListener对象，实现了多种接口
	ButtonListener btl = new ButtonListener();
	public Paint() {//实现一个窗体
		jp.setTitle("画图板");
		jp.setLocation(200, 100);
		jp.setSize(400, 300);
		this.setPreferredSize(new Dimension(600, 500));//声明两个数组，包含各种指令
		String[] command = { "开始", "清除", "直线", "曲线", "多边形", "矩形","椭圆" };
		Color[] color = { Color.BLACK, Color.BLUE, Color.YELLOW, Color.RED, Color.GREEN };//设置布局为流式布局
		jf.setLayout(new FlowLayout());/*在下面的两个循环中将各种按钮添加进入动作监听器中，其中addActionListener参数为btl， btl是一个Buttonlistener的对象*/
		for (int i = 0; i < command.length; i++) {
			JButton jb = new JButton(command[i]);
			jb.addActionListener(btl);
			jp.add(jb);
		}
		for (int i = color.length - 1; i >= 0; i--) {
			JButton jb = new JButton();
			jb.setBackground(color[i]);//设置背景颜色
			Dimension dm = new Dimension(20, 20);//设置大小
			jb.setPreferredSize(dm);
			jb.addActionListener(btl);
			jp.add(jb);
		}
		jp.add(this);
		jp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp.setVisible(true);	//设置可见
		Graphics gf = this.getGraphics();	//获取画笔，我们的this代表当前类的对象，正好是一个JPanel的对象
		this.addMouseListener(btl);		//添加鼠标监听器，用于画图
		this.addMouseMotionListener(btl);	//添加鼠标模式监听器，用于绘画曲线
		btl.set_gr(gf);		//设置另外一个类的画笔
		btl.set_jp(this);	//设置另外一个类的JPanel容器
		btl.set_ShArr(ShArr);	//设置另外一个类的数组
	}
	public void paint(Graphics g) {
		super.paint(g);		//调用父类的paint方法，用来画出窗体
		len = btl.get_len();	//获取数组的长度
		for(int i=0;i<len;i++) {
			if(ShArr[i]!=null) {
				ShArr[i].repaint(g);
			}
			else {
				break;
			}
		}
	}
}
