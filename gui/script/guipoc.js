$(document).ready(function () {

  $('#modelContainer').css('display','none');
  $('#saveModel').css('display','none');
  var attr_count = 0;

  $('#btnCreate').click(function () {
    $('#modelContainer').css('display','block');
    clearAllFields();
    attr_count = 0;
  });

  $('#addmore').click(function () {
    if($("#txtModelName").attr("disabled") != "disabled"){
      $("#txtModelName").attr("disabled", "disabled");
    }

    if($('#saveModel').css('display') == 'none'){
      $('#saveModel').css('display','block');
    }
    var $row = $('<div class = "attributeRow"></div>');
    var $attributeName = $('<div class = "attributeName"><input type="text" placeholder="Attribute Name" class = "modelAttribute" id="attr'  + attr_count++ +  '"></div>');
    var $attributeType = $('<div class = "attributeType"></div>');
    var $select = getAttributeTypes();
    $attributeType.append($select);
    $row.append($attributeName);
    $row.append($attributeType);
    $('#attributeContainer').append($row);
    $('#attributeContainer').scrollTop($('#attributeContainer').get(0).scrollHeight);
    $attributeName.find('.modelAttribute').focus();

  });

  $('#saveModel').click(function () {
    console.log(saveModel());
    clearAllFields();
  });

  $('body').on('keyup','input[type="text"]',function(event){
    if(event.keyCode == 13){
      $("#addmore").click();
    }
  });

});

function getAttributeTypes(){
  var $select = $('<select id="attrType"></select>');
  var dataTypes = ['byte','short','int','long','float','double','boolean','char','String'];
  for(var typeCount = 0; typeCount < dataTypes.length; typeCount++) {
    $select.append('<option value="' + dataTypes[typeCount] + '"> '+ dataTypes[typeCount] +' </option>');
  }
  return $select;
}

function clearAllFields(){
  $('#txtModelName').val("");
  $('#txtModelName').removeAttr("disabled");
  $('#attributeContainer').html('');
}

function saveModel() {
  var model = {};
  model.modelName = $('#txtModelName').val();
  model.attributes = [];
  var $attributes = $('.attributeRow');
  for(var attrCount = 0; attrCount < $attributes.length; attrCount++) {
    var attr = {};
    attr.attributeName = $('.attributeRow').find('.modelAttribute').eq(attrCount).val();
    attr.attributeType = $('.attributeRow').find('#attrType').eq(attrCount).val();
    model.attributes.push(attr);
  }
  return model;
}