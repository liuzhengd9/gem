<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../include/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>图片</title>
		<%@ include file="../include/meta.jsp"%>
		<script type="text/javascript">
	    Ext.require(['*']);
	
	    Ext.onReady(function() {
	
	        Ext.QuickTips.init();
	
	        Ext.state.Manager.setProvider(Ext.create('Ext.state.CookieProvider'));
	        
	        Ext.define('Image', {
			    extend: 'Ext.data.Model',
			    fields: [
			       {name: 'id', type:'int'},
			       {name: 'name', type: 'string'},
			       {name: 'description', type: 'string'},
			       {name: 'relativePath', type: 'string'},
			       {name: 'imageType.name', type: 'string'}
			    ],
			    idProperty: 'id'
			});
	        
			var store = Ext.create('Ext.data.Store', {
			    remoteSort: true,
			    model: 'Image',
			    pageSize: 20, // items per page
			    proxy: {
			        type: 'ajax',
			        url: '<%=request.getContextPath()%>/image/list.html',
			        reader: {
			            type: 'json',
			            root: 'list',
			            totalProperty: 'total'
			        }
			    },
			    listeners: {
			    	refresh: function(s){
			    		if(s.getCount()==0){
			    			Ext.getCmp('pagingtoolbar').movePrevious();
			    		}
			    	}
			    }
			});
			
			store.loadPage(1);
			
			var grid = Ext.create('Ext.grid.Panel', {
			    title: '图片列表',
			    region: 'north',
			    width: '100%',
			    height: '70%',
			    //forceFit: true,
			    columnLines: true,
			    rowLines: true,
			    split: true,
			    renderTo: Ext.getBody(),
			    store: store,
			    selModel: Ext.create('Ext.selection.CheckboxModel',{
			    	ignoreRightMouseSelection: true
			    }),
			    columns: [
			    	{xtype: 'rownumberer', text: '编号', align: 'center', hideable: true, width: 40},
			        {xtype: 'gridcolumn', text: '主键',  dataIndex: 'id', align: 'center', width: '10%', hidden: true},
			        {xtype: 'gridcolumn', text: '名称', dataIndex: 'name', align: 'center', width: '10%'},
			        {
			        	xtype: 'gridcolumn',
			        	text: '路径',
			        	dataIndex: 'relativePath',
			        	align: 'center',
			        	width: '20%',
			        	renderer: function(value){
			        		return value;//'<img src="'+value+'">';
			        	}
			        },
			        {xtype: 'gridcolumn', text: '图片类型', dataIndex: 'imageType.name', align: 'center', width: '20%'},
			        {xtype: 'gridcolumn', text: '描述', dataIndex: 'description', align: 'center', width: '30%'},
			        {
			        	xtype: 'actioncolumn',
			        	text: '操作',
			        	menuDisabled: true,
			        	align: 'center',
			        	width: '10%',
			        	items: [
				        	{
			                    icon: '<%=request.getContextPath()%>/images/icons/fam/cog_edit.png',
			                    tooltip: '修改',
			                    handler: function(grid, rowIndex, colIndex) {
			                        updateRecord('update', grid.getStore().getAt(rowIndex).get('id'));
			                    }
			                }, {
			                    icon: '<%=request.getContextPath()%>/images/icons/fam/delete.gif',
			                    tooltip: '删除',
			                    handler: function(grid, rowIndex, colIndex) {
			                    	Ext.Msg.confirm('提醒','确定删除？',function(v){
			                    		if(v=='yes'){
			                    			deleteRecord(grid.getStore().getAt(rowIndex).get('id'));
			                    		}
			                    	});
			                    }
			                }
		                ]
			        }
			    ],
			    tbar: [
			    	{
			    		xtype: 'button',
			    		text: '增加',
			    		icon: '<%=request.getContextPath()%>/images/icons/fam/add.png',
			    		handler: function(){
			    			 updateRecord('add',null);
			    		}
			    	},'-',{
			    		xtype: 'button',
			    		text: '修改',
			    		icon: '<%=request.getContextPath()%>/images/icons/fam/cog_edit.png',
			    		handler: function(){
			    			var record = grid.getSelectionModel().getLastSelected();
			    			if(record!=null){
			    				updateRecord('update', record.get('id'));
			    			}else{
			    				Ext.Msg.alert('提示','请选择要修改的记录！');
			    			}
			    		}
			    	},'-',{
			    		xtype: 'button',
			    		text: '删除',
			    		icon: '<%=request.getContextPath()%>/images/icons/fam/delete.gif',
			    		handler: function(){
			    			var selections = grid.getSelectionModel().getSelection();
			    			if(selections.length>0){
			    				var ids = new Array();
			    				Ext.each(selections,function(s){
			    					ids.push(s.get('id'));
			    				});
			    				Ext.Msg.confirm('提醒','确定删除？',function(v){
		                    		if(v=='yes'){
		                    			deleteRecord(ids);
		                    		}
		                    	});
			    			}else{
			    				Ext.Msg.alert('提示','请选择要删除的记录！');
			    			}
			    		}
			    	}
			    ],
			    dockedItems: [{
			    	id: 'pagingtoolbar',
			        xtype: 'pagingtoolbar',
			        store: store,
			        dock: 'bottom',
			        displayInfo: true
			    }],
			    viewConfig: {
		            stripeRows: true,
		            enableTextSelection: false
		        },
		        listeners: {
		        	itemdblclick: function(view, record){
		        		updateRecord('update', record.get('id'));
		        	}
		        }
			});
			
			var view = Ext.create('Ext.container.Viewport', {
		        renderTo: Ext.getBody(),
		        layout: 'border',
		        items: [
		        	grid,
		            Ext.create('Ext.form.Panel', {
					    title: '查询',
					    frame: true,
					    region: 'center',
					    autoScroll: true,
					    border: false,
					    buttonAlign: 'center',
					    renderTo: Ext.getBody(),
					    layout: 'anchor',
					    bodyPadding: 10,
					    fieldDefaults: {
				            labelWidth: 75
				        },
					    defaultType: 'textfield',
					    items: [{
					    	xtype: 'fieldset',
					        title: '查询条件',
					        defaultType: 'textfield',
					        layout: 'anchor',
					        items: [{
					    		xtype: 'textfield',
						        fieldLabel: '名称',
						        name: 'name',
						        width: 300
						    }]
				    	}],
					    buttons: [{
					        text: '查询',
					        handler: function() {
					            var form = this.up('form').getForm();
					            store.on('beforeload',function(){
					            	Ext.apply(store.proxy.extraParams, {name: form.getValues()['name']});
					            });
					            Ext.getCmp('pagingtoolbar').moveFirst();
					        }
					    }, {
					        text: '重置',
					        handler: function() {
					            this.up('form').getForm().reset();
					        }
					    }]
					})
		        ]
		    });
			
			Ext.EventManager.onWindowResize(function(){
				view.doLayout();
			});
	    });
	    
	    function deleteRecord(ids){
	    	Ext.Ajax.request({
   				url: '<%=request.getContextPath()%>/image/delete.html',
   				method: 'POST',
   				params: {id: ids},
   				success: function(response){
   					var result = Ext.JSON.decode(response.responseText);
   					console.dir(result);
   					if(result.success){
   						Ext.getCmp('pagingtoolbar').doRefresh();
   					}else{
   						Ext.Msg.alert('提示','删除失败，请重试！');
   					}
   				},
   				failure: function(response){
   					Ext.Msg.alert('错误','删除失败，请重试！');
   				}
   			});
	    }
	    
	    function updateRecord(type, id){
	    
	    	Ext.regModel('ImageType', {
			    fields: [
			        {type: 'int', name: 'id'},
			        {type: 'string', name: 'name'}
			    ]
			});
	    
	    	var imageTypeStore = Ext.create('Ext.data.JsonStore',{
	    		autoLoad: true,
	    		remoteSort: true,
			    model: 'ImageType',
			    pageSize: 10,
			    proxy: {
			        type: 'ajax',
			        url: '<%=request.getContextPath()%>/imageType/list.html',
			        reader: {
			            type: 'json',
			            root: 'list',
			            totalProperty: 'total'
			        }
			    },
			    listeners: {
			    	load: function(store, records){
			    		if(imageTypeCombo.getValue() != null){
				    		Ext.Ajax.request({
				   				url: '<%=request.getContextPath()%>/imageType/load.html',
				   				method: 'POST',
				   				params: {id: imageTypeCombo.getValue()},
				   				success: function(response){
				   					var result = Ext.JSON.decode(response.responseText);
				   					console.dir(result);
				   					if(result.success){
				   						store.add(result.data);
				   						imageTypeCombo.setValue(result.data.id);
				   					}else{
				   						Ext.Msg.alert('提示','加载失败，请重试！');
				   					}
				   				},
				   				failure: function(response){
				   					Ext.Msg.alert('错误','加载失败，请重试！');
				   				}
				   			});
			    		}
			    	}
			    }
	    	});
	    	
	    	var imageTypeCombo = Ext.create('Ext.form.field.ComboBox', {
			    fieldLabel: '图片类型',
			    name: 'imageTypeId',
			    afterLabelTextTpl: '<span style="color:red;font-weight:bold" data-qtip="必填">*</span>',
			    emptyText: '必选',
			    store: imageTypeStore,
			    queryMode: 'remote',
			    pageSize: 10,
			    typeAhead: true,
			    triggerAction: 'all',
			    editable: false,
			    allowBlank: false,
			    forceSelection: true,
			    displayField: 'name',
			    valueField: 'id'
			});
	    
	    	var title = type=='add'?'增加':'修改';
	    	
	    	var formWin =Ext.create('Ext.Window', {
	  			id: 'updateWin',
		        title: title,
		        width: 600,
		        height: 400,
		        plain: true,
		        autoScroll: true,
		        buttonAlign: 'center',
		        modal: true,
		        resizable: true,
		        closable: false,
		        headerPosition: 'top',
		        layout: 'fit',
		        items: [
		            Ext.create('Ext.form.Panel', {
					    frame: true,
					    buttonAlign: 'center',
					    renderTo: Ext.getBody(),
					    layout: 'anchor',
					    autoScroll: true,
					    bodyPadding: 10,
					    border: false,
					    defaults: {
					    	anchor: '100%'
					    },
					    fieldDefaults: {
				            msgTarget: 'side',
				            labelWidth: 70
				        },
				        defaultType: 'textfield',
					    items: [{
					    	xtype: 'fieldset',
					        title: '图片信息',
					        defaultType: 'textfield',
					        layout: 'anchor',
					        defaults: {
						    	anchor: '100%'
						    },
					        items: [{
						        name: 'id',
						        hidden: true
						    },imageTypeCombo,{
						        fieldLabel: '名称',
						        name: 'name',
						        afterLabelTextTpl: '<span style="color:red;font-weight:bold" data-qtip="必填">*</span>',
						        allowBlank: false,
						        emptyText: '必填'
						    },{
						    	xtype: 'filefield',
						        fieldLabel: '图片',
						        name: 'file',
						        buttonText: '选择图片',
						        emptyText: '请上传图片'
						    },{
						        fieldLabel: '路径',
						        name: 'relativePath',
						        readOnly: true
						    },{
						    	xtype: 'htmleditor',
						        fieldLabel: '描述',
						        name: 'description',
						        height: 150
						    }]
				    	}],
					    buttons: [{
					        text: '提交',
					        handler: function() {
					            var form = this.up('form').getForm();
					            var win = this.up('form').up('window');
					            if (form.isValid()) {
					                form.submit({
					                	url: '<%=request.getContextPath()%>/image/persist.html',
					                    success: function(form, action) {
					                    	if(action.result.success){
					                    		form.destroy();
					            				win.destroy();
					                    		Ext.getCmp('pagingtoolbar').doRefresh();
					                    	}else{
					                    		Ext.Msg.alert('成功', action.result.msg);
					                    	}
					                    },
					                    failure: function(form, action) {
					                        Ext.Msg.alert('失败', action.result.msg);
					                    }
					                });
					            }
					        }
					    }, {
					        text: '取消',
					        handler: function() {
					            this.up('form').getForm().destroy();
					            this.up('form').up('window').destroy();
					        }
					    }]
					})
		        ]
		    }).show();
		    
		    if(type!='add'){
			    formWin.down('form').getForm().load({
					url: '<%=request.getContextPath()%>/image/load.html',
					method: 'POST',
					params: {id: id},
					failure: function(form, action) {
			        	Ext.Msg.alert('提示', '加载失败！');
				    }
				});
		    }
	    }
	    </script>
	</head>
	<body>
	</body>
</html>
