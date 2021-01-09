$(function () {
    var pageSize = 24; // Hiển thị 6 sản phẩm trên 1 trang
    showPage = function (page) {
        $(".contentPage").hide();
        $(".contentPage").each(function (n) {
            if (n >= pageSize * (page - 1) && n < pageSize * page)
                $(this).show();
        });
    }
    showPage(1);
    ///** Cần truyền giá trị vào đây **///
    var totalRows = 153; // Tổng số sản phẩm hiển thị
    var btnPage = 3; // Số nút bấm hiển thị di chuyển trang
    var iTotalPages = Math.ceil(totalRows / pageSize);

    var obj = $('#pagination').twbsPagination({
        totalPages: iTotalPages,
        visiblePages: btnPage,
        onPageClick: function (event, page) {
            console.info(page);
            showPage(page);
        }
    });
    console.info(obj.data());
});

// brand auto play footer
$('.slide-auto-click').slick({
    slidesToShow: 6,
    autoplay: true,
     responsive: [{
          breakpoint: 1024,
          settings: {
            slidesToShow: 4,
            slidesToScroll: 1,
            autoplay: true,
            autoplaySpeed: 3000,
            centerMode: true,
            variableWidth: true
          }
        },
        {
          breakpoint: 720,
          settings: {
            slidesToShow: 3,
            slidesToScroll: 1,
            autoplay: true,
            autoplaySpeed: 3000,
            centerMode: true,
            variableWidth: true
          }
        },
        // điểm ngắt
        {
          breakpoint: 540,
          settings: {
                slidesToShow: 2,
                slidesToScroll:1,
                autoplay: true,
                autoplaySpeed: 3000,
                centerMode: true,
                variableWidth: true

          }
        }

      ]
});


// auto hidden menu mobile
$(document).ready(function() {
	$(window).scroll(function (event) { 
		var height_body = $('html, body').scrollTop();
		//  console.log(heihgt_body);
		if( height_body <=30) {
			$('.menu-mobile-icon').addClass('color-menu-mobile-icon_start');
			$('.menu-mobile').removeClass('hidden-menu-mobile');
		} else if(height_body >30 && height_body <=120) {
			$('.menu-mobile').addClass('hidden-menu-mobile');
			$('.menu-mobile-icon').removeClass('color-menu-mobile-icon_start')
		} else {
			$('.menu-mobile').removeClass('hidden-menu-mobile');
			$('.menu-mobile-icon').addClass('color-menu-mobile-icon_end');
		}
		
		
	});
})
