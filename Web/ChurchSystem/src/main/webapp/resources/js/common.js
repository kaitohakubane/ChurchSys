/**
 * Created by hungmcse61561-admin on 6/29/2017.
 */
function eventRegisterPopup(e, popup) {
    console.log("popup")
    var windowHeight = $(window).height() / 2;
    var windowWidth = $(window).width() / 2;
    if (e.clientY > windowHeight && e.clientX <= windowWidth) {
        popup.css("left", e.clientX + defaultMovePlus);
        popup.css("bottom", $(window).height() - e.clientY + defaultMovePlus);
        popup.css("right", "auto");
        popup.css("top", "auto");
        popup.fadeIn();
    } else if (e.clientY > windowHeight && e.clientX > windowWidth) {
        popup.css("right", $(window).width() - e.clientX + defaultMovePlus);
        popup.css("bottom", $(window).height() - e.clientY + defaultMovePlus);
        popup.css("left", "auto");
        popup.css("top", "auto");
        popup.fadeIn();
    } else if (e.clientY <= windowHeight && e.clientX <= windowWidth) {
        popup.css("left", e.clientX + defaultMovePlus);
        popup.css("top", e.clientY + defaultMovePlus);
        popup.css("right", "auto");
        popup.css("bottom", "auto");
        popup.fadeIn();
    } else {
        popup.css("right", $(window).width() - e.clientX + defaultMovePlus);
        popup.css("top", e.clientY + defaultMovePlus);
        popup.css("left", "auto");
        popup.css("bottom", "auto");
        popup.fadeIn();
    }


}