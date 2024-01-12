(function($) {
  "use strict"; // Start of use strict

  // Toggle the side navigation
  $("#sidebarToggle, #sidebarToggleTop").on('click', function(e) {
    $("body").toggleClass("sidebar-toggled");
    $(".sidebar").toggleClass("toggled");
    if ($(".sidebar").hasClass("toggled")) {
      $('.sidebar .collapse').collapse('hide');
    };
  });

  // Close any open menu accordions when window is resized below 768px
  $(window).resize(function() {
    if ($(window).width() < 768) {
      $('.sidebar .collapse').collapse('hide');
    };
    
    // Toggle the side navigation when window is resized below 480px
    if ($(window).width() < 480 && !$(".sidebar").hasClass("toggled")) {
      $("body").addClass("sidebar-toggled");
      $(".sidebar").addClass("toggled");
      $('.sidebar .collapse').collapse('hide');
    };
  });

  // Prevent the content wrapper from scrolling when the fixed side navigation hovered over
  $('body.fixed-nav .sidebar').on('mousewheel DOMMouseScroll wheel', function(e) {
    if ($(window).width() > 768) {
      var e0 = e.originalEvent,
        delta = e0.wheelDelta || -e0.detail;
      this.scrollTop += (delta < 0 ? 1 : -1) * 30;
      e.preventDefault();
    }
  });

  // Scroll to top button appear
  $(document).on('scroll', function() {
    var scrollDistance = $(this).scrollTop();
    if (scrollDistance > 100) {
      $('.scroll-to-top').fadeIn();
    } else {
      $('.scroll-to-top').fadeOut();
    }
  });

  // Smooth scrolling using jQuery easing
  $(document).on('click', 'a.scroll-to-top', function(e) {
    var $anchor = $(this);
    $('html, body').stop().animate({
      scrollTop: ($($anchor.attr('href')).offset().top)
    }, 1000, 'easeInOutExpo');
    e.preventDefault();
  });

  $('#openpop').on('click',function(e){
    e.preventDefault();

    $('#popup').css('display','');
    //$(this).val('true');
    popup.classList.remove('hide');
    popup.classList.add('has-filter');
    if (hasFilter) {
      popup.classList.add('has-filter');
    } else {
      popup.classList.remove('has-filter');
    }


  });
  $('#closepopupbtn').on('click',function(e){
    e.preventDefault();
    popup.classList.remove('has-filter');
    popup.classList.add('hide');
  });

  $(document).ready(function() {
    // 'loanTerm' 드롭다운의 값이 변경되었을 때 이벤트를 발생시킵니다.
    $("#loanTerm").change(function() {
      // 선택된 옵션의 값을 가져옵니다.
      var selectedValue = Number($(this).val());

      // 선택된 값에 따라 'interestRate' 필드의 값을 설정합니다.
      if (selectedValue === 12) {
        $("#interestRate").val(5.6);
      } else if (selectedValue === 24) {
        $("#interestRate").val(5.7);
      }
      else if (selectedValue === 36) {
        $("#interestRate").val(5.8);
      }
      else if (selectedValue === 48) {
        $("#interestRate").val(5.9);
      }
    });
  });
  $(document).ready(function() {
    // carPrice와 deposit 값을 가져옵니다.
    var carPrice = parseFloat(document.getElementById('carPrice').value);
    var deposit = parseFloat(document.getElementById('deposit').value);

    // carPrice와 deposit가 입력되었을 때만 계산을 수행합니다.
    if (!isNaN(carPrice) && !isNaN(deposit)) {
      // deposit 값이 0이면 carPrice를 그대로 표시합니다.
      if (deposit === 0) {
        document.getElementById('hopeAmount').value = carPrice;
      } else {
        // deposit 값이 0이 아니면 hopeAmount에 carPrice에서 deposit 비율을 곱한 값을 뺀 결과를 표시합니다.
        document.getElementById('hopeAmount').value = carPrice - (carPrice * deposit / 100);
      }
    }
  });

  // carPrice 또는 deposit 값이 변경되었을 때 계산을 다시 수행합니다.
  $("#carPrice, #deposit").on("change", function() {
    var carPrice = parseFloat(document.getElementById('carPrice').value);
    var deposit = parseFloat(document.getElementById('deposit').value);

    if (!isNaN(carPrice) && !isNaN(deposit)) {
      if (deposit === 0) {
        document.getElementById('hopeAmount').value = carPrice;
      } else {
        document.getElementById('hopeAmount').value = carPrice - (carPrice * deposit / 100);
      }
    }
  });




})(jQuery); // End of use strict
