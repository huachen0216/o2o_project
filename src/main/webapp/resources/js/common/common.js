/**
 *
 * @param img
 */
function changeVerifyCode(img) {
    img.src="../Kaptcha?" + Math.floor(Math.random() * 100);
}

/**
 *
 * @param name
 * @returns {string}
 */
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return decodeURIComponent(r[2]);
    }
    return '';
}

/**
 * 验证手机号是否合法
 */
function isPhone(phone){
    var RegCellPhone = /^(1)([0-9]{10})?$/;
    var  falg=phone.search(RegCellPhone);
    if (falg==-1){
        $.toast('请输入正确的联系电话 !');
        this.focus();
    }
}