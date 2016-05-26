module ApplicationHelper
  def bootstrap_class_for(flash_type)
    case flash_type
    when 'success'
      'alert-success'
    when 'error'
      'alert-error'
    when 'alert'
      'alert-warning'
    when 'notice'
      'alert-info'
    else
      flash_type.to_s
    end
  end

  def color_score(score)
    data = if score > 75
             "<div class=\"Score_green\">#{score.round}</div>"
           elsif score > 50
             "<div class=\"Score_yellow\">#{score.round}</div>"
           else
             "<div class=\"Score_red\">#{score.round}</div>"
           end
    data.html_safe
  end
end
