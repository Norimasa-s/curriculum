package check;

public class Pet {
//フィールド
    private String name;
    private String masterName;
    // privateはこのクラスだけアクセスできる。
    
//コンストラクタ
    public Pet(String name, String masterName) {
        this.name = name;
        this.masterName = masterName;
// 自クラスのインスタンスであることを明示するもの。
    }
//外のフィールドからアクセスするためにgetメソッドを使っている。
    protected String getName() {
        return name;
    }
// protectedはメインクラスと継承されたサブクラスのみで使われる。
    protected String getMasterName() {
        return masterName;
    }
// 戻り値(return)のない場合はvoidをつける。
    public void introduce() {
        System.out.println("■僕の名前は" + this.name + "です");
        System.out.println("■ご主人様は" + this.masterName + "です");
    }
}
//親がsuperを使う。
//extendsで継承している。この場合はPetクラスが親クラス。
class RobotPet extends Pet {
    public RobotPet(String name, String masterName) {
        // 親クラスと明示するためsuperがついている。
        super(name, masterName);
    }

    public void introduce() {
        //この場合はオーバーライド。親クラスのメソッドを子クラスで上書き。
        // 戻り値がないためvoidがある。
        System.out.println("◇私はロボット。名前は" + getName() + "。");
        System.out.println("◇ご主人様は" + getMasterName() + "。");
    }
}
