function f_addBtm(obj) {
        var tzs = obj.getElementsByClassName("tzs")[0];
        var coins = document.getElementsByClassName("coins")[0];
        var coin = parseInt(coins.innerHTML);
        if( coin ==0)
        {
            f_show_msg("余额不足,请先完成充值再下注!");
            return;
        }
        coins.innerHTML =coin -1;
        var tz = 0;
        tz = parseInt(tzs.innerHTML) + 1;
        tzs.innerHTML = tz;
        $(obj).children(".tzs").css({display: "inline-block"});
    }
function f_show_login() {
        $(".pop-bg").css({display: "block", height: $(document).height()});
        $(".login-pop").css(
            {
                left: ($("body").width() - $(".login-pop").width()) / 2 - 20 + "px",
                top: ($(window).height() - $(".login-pop").height()) / 2 + $(window).scrollTop() + "px",
                display: "block"
            }
        );
    }
 function f_show_cz()
    {
        var pho =$("#pho").val();
        if(pho =='')
        {
            f_show_msg("用户还未登录!");
            return ;
        }
        $(".pop-bg").css({display: "block", height: $(document).height()});
        $(".cz-pop").css(
            {
                left: ($("body").width() - $(".cz-pop").width()) / 2 - 20 + "px",
                top: ($(window).height() - $(".cz-pop").height()) / 2 + $(window).scrollTop() + "px",
                display: "block"
            }
        );

    }
   function f_show_tx()
    {

        var pho =$("#pho").val();
        if(pho =='')
        {
          f_show_msg("用户还未登录!");
          return ;
          }
        $(".pop-bg").css({display: "block", height: $(document).height()});
        $(".tx-pop").css(
            {
                left: ($("body").width() - $(".tx-pop").width()) / 2 - 20 + "px",
                top: ($(window).height() - $(".tx-pop").height()) / 2 + $(window).scrollTop() + "px",
                display: "block"
            }
        );
    }
   function f_show_msg(text)
    {
        $(".pop-bg").css({display: "block", height: $(document).height()});
        $(".msg-pop").css(
            {
                left: ($("body").width() - $(".msg-pop").width()) / 2 - 20 + "px",
                top: ($(window).height() - $(".msg-pop").height()) / 2 + $(window).scrollTop() + "px",
                display: "block"
            }
        );
        $(".msg-pop .showMsg").html(text);
    }
    function f_close() {
        $(".pop-bg ,.login-pop ,.run-pop ,.cz-pop ,.tx-pop ").fadeOut();
    }
    function  f_close_msg()
    {
        $(".pop-bg ,.msg-pop").fadeOut();
    }
  var t_shij =0;
  var inter=0;
  var won =0;
  var rebl=0;
function f_runHorse()
  {

      var tz = f_getBtm();
      if(tz ==0)
      {
        f_show_msg("还未下注,请完成下注后再开!");
        return ;
      }
      $(".pop-bg").css({display: "block", height: $(document).height()});
      $(".run-pop").css(
          {
              left: ($("body").width() - $(".run-pop").width()) / 2 - 20 + "px",
              top: ($(window).height() - $(".run-pop").height()) / 2 + $(window).scrollTop() + "px",
              display: "block"
          }
      );
      $.ajax({
      url:"/zmResult",
      type:"post",
      beforeSend:function(request){
                  request.setRequestHeader("token",localStorage.token);
              },
      success:function(data){
      if(data.code==500)
       {
            window.location='/horse';
            return ;
        }
        var obj =data;
        var index = obj.zindex;
        var zmbl = obj.zmbl;
        rebl =zmbl;
        var btm =parseInt(document.getElementsByClassName("tzs")[index].innerHTML);
        won = zmbl * btm;
        document.getElementsByClassName("runpic")[0].src="images/"+obj.pic;
        document.getElementsByClassName("showBtm")[0].innerHTML=''+zmbl+'('+won+')';
        document.getElementsByClassName("zindex")[0].innerHTML=index;
      }
      });
      var video =document.getElementsByTagName("audio")[0];
      video.pause();
      video.src="images/run.MP3";
      video.play();
      t_shij =30;
      inter =window.setInterval("f_colck()",1000);
  }
function f_colck() {
        t_shij -= 1;
        if(t_shij == 3)
        {
            $(".showBtm").css({display:"block"});
            var video =document.getElementsByTagName("audio")[0];
            if(won >0)
            {
                video.pause();
                video.src="images/win.MP3";
                video.play();

            }
            $(".win").html(won);
            f_runData();
            f_fresh_msg();
        }
        if (t_shij == 0)
        {
            window.clearInterval(inter);
            $(".showBtm").css({display:"none"});
            $(".pop-bg ,.run-pop").fadeOut();
            var coins =parseInt(document.getElementsByClassName("coins")[0].innerHTML);
            coins =coins + won;
            $(".coins").html(coins);
            $(".maxtx").html("("+coins+")");
            f_getData();
        }
    }
function f_login()
    {
        var pho =$("#pho").val();
        var scode =$("#scode").val();
        if(  pho =="")
        {
            f_show_msg("手机号不能为空!");
            return;
        }
        if(scode =="")
        {
            f_show_msg("验证码不能为空!");
            return ;
        }
        $.ajax({
        url:"/login",
        type:"post",
        data:{uname:pho,scode:scode},
        dataType:"json",
        success:function(data){
        var obj =data;
        if(obj.text=="登录成功!")
        {
             localStorage.token=obj.token;
             $("#logi").html('**'+pho.substr(7,4));
             $(".user").html('**'+pho.substr(7,4));
             $(".pho").html(pho);
             $(".maxtx").html("("+obj.coins+")");
             $(".coins").html(obj.coins);
             $("img")[3].src="zfb_"+pho+obj.ptype;
             f_close();
             f_getData();
           }else
                f_show_msg("手机号或验证码输入错误!");
        }
        });
    }
    function f_sendsms()
    {
        var pho =$("#pho").val();
        if(  pho =="")
        {
            f_show_msg("手机号不能为空!");
            return;
        }
        var ycode =document.getElementsByClassName("ycode")[0].innerHTML;
        $.ajax({
        url:"/sendSms",
        type:"post",
        data:{pho:pho,ycode:ycode},
        dataType:"json",
        success:function(data){
         f_show_msg("验证码已发送!")
         $('.sendsms').hide();
        }
        });
    }
    function f_user_cz()
    {

        var pho =document.getElementsByClassName("pho")[0].innerHTML;
        if(pho =='')
        {
            f_show_msg("请先完成登录再充值!")
            return ;
        }
        var sel =document.getElementsByClassName("czje")[0];
        var ind =sel.selectedIndex;
        var czs =parseInt(sel.options[ind].value);
        var img =document.getElementsByTagName("img")[2].src;
        var ctype ='zfb';
        if(pho =='')
        {
            f_show_msg("用户还未登录，请先完成登录!");
            return ;
        }
        if(czs ==0)
        {
            f_show_msg("请选择充值金额!");
            return;
        }
        $.ajax({
        url:"/coinsCZ",
        type:"post",
        data:{uname:pho,czs:czs,ctype:ctype},
        dataType:"json",
        success:function(data){
            f_close();
        }
        });
    }

     function f_user_tx()
    {
        var pho =document.getElementsByClassName("pho")[0].innerHTML;
        if(pho =='')
          {
             f_show_msg("请先完成登录再提现!")
             return ;
          }
        var tsl =document.getElementsByClassName("txsl")[0].value;
        var img =document.getElementsByTagName("img")[3].src;
        var ttype ='zfb';
        if(pho =='')
        {
            f_show_msg("用户还未登录，请先完成登录!");
            return ;
        }
        if(tsl =='')
        {
            f_show_msg("请输入提现数量!");
            return ;
        }
        $.ajax({
        url:"/coinsTX",
        type:"post",
        data:{uname:pho,tsl:tsl,ttype:ttype},
        dataType:"json",
        success:function(data){
            f_close();
        }
        });
    }
    function f_runData()
    {
        var bls =document.getElementsByClassName("btm");
        var tzs =document.getElementsByClassName("tzs");
        var pho =document.getElementsByClassName("pho");
        var ibl=[];
        var itz=[];
        for(var i =0 ;i<bls.length;i++)
        {
           ibl.push(bls[i].innerHTML);
           itz.push(tzs[i].innerHTML);
        }
        var raceObj = new Object();
        raceObj.bls=ibl;
        raceObj.btms=itz;
        raceObj.zmbl=rebl;
        raceObj.uname=pho[0].innerHTML;
        $.ajax({
        url:"/runHorse",
        type:"post",
        contentType:'application/json;charset=utf-8',
        data:JSON.stringify(raceObj),
        beforeSend:function(request){
                    request.setRequestHeader("token",localStorage.token);
                },
        success:function(data){
            if(data.code==500)
            {
                window.location='/horse';
                return ;
            }

        }
        });
    }
    function f_getData()
    {
        $.ajax({
        url:"/getData",
        type:"post",
        beforeSend:function(request){
            request.setRequestHeader("token",localStorage.token);
        },
        success:function(data)
        {
             if(data.code==500)
             {
                window.location='/horse';
                 return ;
               }
            var btm =document.getElementsByClassName("btm");
            var tzs =document.getElementsByClassName("tzs");
            var img =document.getElementsByClassName("runpic");
            var obj = data;
            for(var i =0;i<obj.bls.length;i++)
            {
                btm[i].innerHTML=obj.bls[i];
                tzs[i].innerHTML="0";
            }
            $(".tzs").css({display: "none"});
        }
        });
    }
    function f_fresh_msg()
    {
        var oma = document.getElementsByClassName("oma");
        var obt = document.getElementsByClassName("obtm");
        var zindex = parseInt(document.getElementsByClassName("zindex")[0].innerHTML);
        var zmbl = rebl;
        var nma ='';
        switch(zindex)
        {
            case 0:nma ='1-6';
                break;
            case 1:nma ='1-5';
                break;
            case 2:nma ='1-4';
                break;
            case 3:nma ='1-3';
                break;
            case 4:nma ='1-2';
                break;
            case 5:nma ='2-6';
                break;
            case 6:nma ='2-5';
                 break;
            case 7:nma ='2-4';
                break;
            case 8:nma ='2-3';
                break;
            case 9:nma ='3-6';
                break;
            case 10:nma ='3-5';
                break;
            case 11:nma ='3-4';
                break;
            case 12:nma ='4-6';
                break;
            case 13:nma ='4-5';
                break;
            case 14:nma ='5-6';
                break;
        }
        oma[4].innerHTML =oma[3].innerHTML;
        oma[3].innerHTML =oma[2].innerHTML;
        oma[2].innerHTML =oma[1].innerHTML;
        oma[1].innerHTML =oma[0].innerHTML;
        oma[0].innerHTML =nma;

        obt[4].innerHTML =obt[3].innerHTML;
        obt[3].innerHTML =obt[2].innerHTML;
        obt[2].innerHTML =obt[1].innerHTML;
        obt[1].innerHTML =obt[0].innerHTML;
        obt[0].innerHTML =zmbl;
        var tx =document.getElementsByClassName("ms-info")[0];
        var text =tx.innerHTML;
        if(text!='')
            text +='\n';
        var dat = new Date();
        var df ='['+dat.getHours()+":"+dat.getMinutes()+":"+dat.getSeconds()+"]";
        tx.innerHTML = text +df+'【'+nma +'】('+zmbl+') win:'+won+'(coins)';
    }

    function f_getBtm()
    {
        var btms = document.getElementsByClassName("tzs");
        var tz =0;
        for (var i =0 ;i<btms.length;i++)
            tz += parseInt(btms[i].innerHTML);
        return tz;
    }
    function submit2()
    {
        var type='file';
        var id='cert';
        var formData = new FormData();
        var pho =document.getElementsByClassName("pho");
        var user =pho[0].innerHTML;
        user ="zfb_"+user;
        formData.append(type,$("#"+id)[0].files[0]);
        formData.append("user",user);
         var img =document.getElementsByTagName("img")[3];
         img.src='';
        $.ajax({
            url:"/upload",
            type:"post",
            data:formData,
            cache:false,
            processData:false,
            contentType:false,
            success:function(data){
                img.src=data;
                f_show_msg("收款地址保存成功!");
            }
        });
    }

document.ondrop = function(event) {
return false;
};
document.ondragenter  = function(event) {
return false;
};
document.ondragover  = function(event) {
return false;
};