package com.example.demo.utils;
public class TencentAPI {
	//自己的APPID
	public static final Integer APP_ID_AI = 1106703112;  //自行修改
	//自己的APPKEY
	public static final String APP_KEY_AI = "JjoNS14dguVIgyyJ";//自行修改
	public static final String OCR_G = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_generalocr";  //身份证识别

	public static final String PERSON_ID = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_idcardocr";  //身份证识别
	public static final String PHOTO_SPEAK = "https://api.ai.qq.com/fcgi-bin/vision/vision_imgtotext"; //看图说话
	public static final String SCENE_RECOGNITION  = "https://api.ai.qq.com/fcgi-bin/vision/vision_scener"; //场景识别：对图行进行场景识别，快速找出图片中包含的场景信息
	public static final String OBJECT_RECOGNITION = "https://api.ai.qq.com/fcgi-bin/vision/vision_objectr"; //物体识别:对图行进行物体识别，快速找出图片中包含的物体信息
	public static final String IMAGE_LABEL = "https://api.ai.qq.com/fcgi-bin/image/image_tag"; //图像标签识别:识别一个图像的标签信息,对图像分类。
	public static final String FACE_MERGE = "https://api.ai.qq.com/fcgi-bin/ptu/ptu_facemerge";  //人脸融合
	public static final String PHOTOFORTRANSLATE="https://api.ai.qq.com/fcgi-bin/nlp/nlp_imagetranslate";  //图片翻译
	//自己添加
}
