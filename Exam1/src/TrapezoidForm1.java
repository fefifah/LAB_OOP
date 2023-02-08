import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TrapezoidForm1 extends JFrame {

	private JPanel contentPane;
	private JLabel lblBase1, lblBase2, lblHeight;
	private JTextField txtBase1, txtBase2, txtHeight;
	private JButton btnCalculate;
	
	
	public TrapezoidForm1() {
		setTitle("Trapezoid Area Calculator");
    	setBounds(100, 100, 300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel base1Label = new JLabel("Base 1:");
        base1Label.setBounds(58, 89, 52, 14);
        getContentPane().add(base1Label);

        txtBase1 = new JTextField();
        txtBase1.setBounds(120, 86, 86, 20);
        getContentPane().add(txtBase1);
        txtBase1.setColumns(10);

        JLabel base2Label = new JLabel("Base 2:");
        base2Label.setBounds(58, 120, 52, 14);
        getContentPane().add(base2Label);

        txtBase2 = new JTextField();
        txtBase2.setBounds(120, 117, 86, 20);
        getContentPane().add(txtBase2);
        txtBase2.setColumns(10);

        JLabel heightLabel = new JLabel("Height:");
        heightLabel.setBounds(59, 151, 51, 14);
        getContentPane().add(heightLabel);

        txtHeight = new JTextField();
        txtHeight.setBounds(120, 148, 86, 20);
        getContentPane().add(txtHeight);
        txtHeight.setColumns(10);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(28, 56, 233, 2);
        getContentPane().add(separator);
        
        JLabel lblNewLabel = new JLabel("Trapezoid Area Calculator");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setBounds(33, 31, 214, 14);
        getContentPane().add(lblNewLabel);
        
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(111, 191, 95, 23);
        getContentPane().add(calculateButton);
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (txtBase1.getText().isEmpty() || txtBase2.getText().isEmpty() ||txtHeight.getText().isEmpty()) {
                    showError("Please enter values for all the fields.");
                } else {
                    try {
                        double base1 = Double.parseDouble(txtBase1.getText());
                        double base2 = Double.parseDouble(txtBase2.getText());
                        double height = Double.parseDouble(txtHeight.getText());

                        /*if (base1 < 0) {
                            showError("Base 1 cannot be negative. Converting to positive value.");
                            base1 = Math.abs(base1);
                            txtBase1.setText(String.valueOf(base1));
                        }
                        if (base2 < 0) {
                            showError("Base 2 cannot be negative. Converting to positive value.");
                            base2 = Math.abs(base2);
                            txtBase2.setText(String.valueOf(base2));
                        }
                        if (height < 0) {
                            showError("Height cannot be negative. Converting to positive value.");
                            height = Math.abs(height);
                            txtHeight.setText(String.valueOf(height));
                        }*/
                        
                        if (base1 < 0 || base2 < 0 || height < 0) {
                            showError("Negative values are not allowed.");
                            base1 = Math.abs(base1);
                            base2 = Math.abs(base2);
                            height = Math.abs(height);
                            txtBase1.setText(String.valueOf(base1));
                            txtBase2.setText(String.valueOf(base2));
                            txtHeight.setText(String.valueOf(height));
                            
                        }else {
                            double area = calculateArea(base1, base2, height);
                            showResult(area);
                            txtBase1.setText("");
                            txtBase2.setText("");
                            txtHeight.setText("");
                        }
                    } catch (NumberFormatException ex) {
                        showError("Invalid input. Please enter a valid number.");
                        txtBase1.setText("");
                        txtBase2.setText("");
                        txtHeight.setText("");
                	}
                }
            }
        });
    }


		private double calculateArea(double base1, double base2, double height) {
			return (base1 + base2) / 2 *height;
		}
		
		private void showResult() {
			JOptionPane.showMessageDialog(this, "The area of the trapezoid is: ");
		}
		private void showResult(double area) {
			JOptionPane.showMessageDialog(this, "The area of the trapezoid is: " + area);
		}
		private void showError(String message) {
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
		}

		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						TrapezoidForm1 frame = new TrapezoidForm1();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
