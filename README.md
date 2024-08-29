# SimpleAdapter
    Android 使用ViewBinding的RecyclerView Adapter的封装，简单易用。
## **1、导入**

 1.引入jitpack
 项目根目录中的settings.gradle
 ```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://www.jitpack.io")}
    }
}
```
2.添加
 Module的build.gradle
```
implementation("com.github.summersrest:SimpleAdapter:v2.0.2")
```

## **2、使用**

### 1、单布局使用方法
```kotlin
class MyAdapter(context: Context, data: List<String>): SimpleAdapter<ItemLeftBinding, String>(context, data) {
    override fun getViewBinding(viewType: Int, layoutInflater: LayoutInflater, parent: ViewGroup): ItemLeftBinding {
        return ItemLeftBinding.inflate(layoutInflater, parent, false)
    }

    override fun onBind(context: Context, binding: ItemLeftBinding, position: Int, item: String) {
        binding.tvText.text = item
    }

}
```

```kotlin
val data = listOf("变形金刚", "泰坦尼克号", "X战警", "巨齿鲨", "流浪地球", "奥本海默", "拯救大兵瑞恩", "星际大战")
val adapter = MyAdapter(this, data)
viewBinding.recyclerView.layoutManager = LinearLayoutManager(this)
viewBinding.recyclerView.adapter = adapter
```
点击事件
```kotlin
adapter.setOnItemClickListener { position, item ->
    Toast.makeText(this, "$position: $item", Toast.LENGTH_SHORT).show()
}
```

### 2、多布局使用方法
```kotlin
val data = listOf("变形金刚", "泰坦尼克号", "X战警", "巨齿鲨", "流浪地球", "奥本海默", "拯救大兵瑞恩", "星际大战")
val adapter = SimpleMultipleAdapter(this, data)
adapter.add(LeftEntrust())
adapter.add(RightEntrust())
viewBinding.recyclerView.layoutManager = LinearLayoutManager(this)
viewBinding.recyclerView.adapter = adapter
```
Entrust
```kotlin
class LeftEntrust: Entrust<ItemLeftBinding, String>() {
    override fun getViewBinding(layoutInflater: LayoutInflater, parent: ViewGroup): ItemLeftBinding {
        return ItemLeftBinding.inflate(layoutInflater, parent, false)
    }

    override fun isThisType(t: String): Boolean {
        return t.length <= 4
    }

    override fun onBind(context: Context, binding: ItemLeftBinding, position: Int, item: String) {
        binding.tvText.text = "${item}：我在左边"
    }

}
```
```kotlin
class RightEntrust: Entrust<ItemRightBinding, String>() {
    override fun getViewBinding(layoutInflater: LayoutInflater, parent: ViewGroup): ItemRightBinding {
        return ItemRightBinding.inflate(layoutInflater, parent, false)
    }

    override fun isThisType(t: String): Boolean {
        return t.length > 4
    }

    override fun onBind(context: Context, binding: ItemRightBinding, position: Int, item: String) {
        binding.tvText.text = "${item}：我在右边"
    }

}
```


## 感谢


* [https://github.com/hongyangAndroid/baseAdapter](https://github.com/hongyangAndroid/baseAdapter)

* [https://github.com/meijingkang/baseAdapter](https://github.com/meijingkang/baseAdapter)
	

