# ProgressBar
okhttp与progressbar

PictureProgressBar 的使用


Gradle

    compile 'com.yanzhikaijky:PictureProgressbar:1.1.0'

属性
属性名称 	意义 	类型 	默认值
backGroundColor 	进度条背景颜色 	color 	#888888

barColor 	进度条颜色 	color 	#ff0000

drawable 	进度条图片drawable 	drawable 	null

halfDrawableWidth 	drawable宽度 	dimension 	0

halfDrawableHeight 	drawable高度 	dimension 	0
drawableHeightOffset 	drawable高度偏移量 	dimension 	0
isRound 	进度条是否为圆角 	boolean 	true
roundX 	进度条圆角X半径 	dimension 	20px
roundY 	进度条圆角Y半径 	dimension 	20px
progress 	初始进度 	int 	0
max 	最大进度 	int 	0
isSetBar 	是否自定义进度条高度 	boolean 	flase
progressHeight 	进度条高度 	dimension 	100px
progressHeightOffset 	进度条高度偏移量 	dimension 	
refreshTime 	刷新时间 	int 	100
animMode 	动画模式 	eunm 	ANIM_NULL
rotateRate 	旋转角度/每次刷新 	int 	10
rotateDegree 	旋转初始角度 	int 	0
scaleMax 	缩放最大倍数 	float 	1.5f
scaleMin 	缩放最小倍数 	float 	0.5f
scaleRate 	缩放倍数/每次刷新 	float 	0.1
gradientStartColor 	进度条渐变色开始颜色 	color 	#ff0000
gradientEndColor 	进度条渐变色结束颜色 	color 	#ffff00

    注意：上面的drawable属性可以是图片，也可以是Shape（demo里面的正方形就是自动画的Shape），其他的类型应该不行了。

