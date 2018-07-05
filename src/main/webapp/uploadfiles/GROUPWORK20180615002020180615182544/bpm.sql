SELECT tb0.requestid AS "请求id",
       tb0.workflowid AS "工作流id",
       tb0.currentnodeid AS "当前节点id",
       (SELECT tbin0.NODENAME
          FROM workflow_nodebase tbin0
         WHERE tbin0.id = tb0.currentnodeid)
          AS "当前节点名称",
       tb0.requestname AS "流程名称",
       ( select tbin1.lastname from hrmresource tbin1 where tbin1.id= tb0.creater) AS "创建人",
       tb0.createdate AS "创建日期",
       tb0.createtime AS "创建时间",
       （select tbin2.lastname from hrmresource tbin2 where tbin2.id=tb1.operator） as "审批人/操作人",
       CASE tb1.logtype 
  WHEN '0' THEN '批准' 
  WHEN '1' THEN '保存'
  WHEN '2' THEN '提交'
  WHEN '3' THEN '退回'
  WHEN '4' THEN '重新打开'
  WHEN '5' THEN '删除'
  WHEN '6' THEN '激活'
  WHEN '7' THEN '转发'  
  WHEN '9' THEN '批注'
  WHEN 'e' THEN '强制归档'
  WHEN 't' THEN '抄送'
  WHEN 's' THEN '督办'
  else '其它'
  
  END as "签字类型",
  tb1.operatedate as "签字/审批日期",
  tb1.operatetime as "签字/审批时间",
  tb1.remark as "审批意见",
  tb1.destnodeid as "下一节点ID",
  (SELECT tbin2.NODENAME
          FROM workflow_nodebase tbin2
         WHERE tbin2.id = tb1.destnodeid)
          AS "下一节点名称"
  FROM workflow_requestbase tb0,workflow_requestlog tb1 
 WHERE requestname = '培训申请-王道文-2018-05-2502'
 
 and tb0.requestid = tb1.requestid
 and tb0.workflowid = tb1.workflowid
 
 
ORDER BY tb1.operatedate || tb1.operatetime ASC;